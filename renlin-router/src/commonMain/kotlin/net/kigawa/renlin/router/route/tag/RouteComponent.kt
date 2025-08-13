package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.component.Component2
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.dsl.RegisteredDslData
import net.kigawa.renlin.dsl.StatedDsl
import net.kigawa.renlin.router.route.Route
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.w3c.category.ContentCategory
import net.kigawa.renlin.w3c.element.TagNode
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class RouteComponent<CONTENT_CATEGORY: ContentCategory>(
    private val routerDsl: RouterDsl<CONTENT_CATEGORY>,
): Component2<Tag<CONTENT_CATEGORY>, CONTENT_CATEGORY, Route, StatedDsl<out CONTENT_CATEGORY>.() -> Unit> {
    override fun render(
        parentDsl: StatedDsl<out CONTENT_CATEGORY>, arg1: Route,
        arg2: StatedDsl<out CONTENT_CATEGORY>.() -> Unit, key: String?,
    ) {
        if (arg1.isMach(routerDsl.routePath)) {
            @OptIn(ExperimentalUuidApi::class)
            val nonNullKey = key ?: Uuid.random().toString()
            val state = parentDsl.dslState.getOrCreateSubDslState(nonNullKey, this)
            val routerDsl = object: DslBase<CONTENT_CATEGORY>(state) {
                override fun applyElement(element: TagNode): () -> Unit {
                    return parentDsl.applyElement(element)
                }
            }
            parentDsl.arg2()
            parentDsl.registerSubDsl(
                RegisteredDslData(
                    routerDsl, this,
                    { render(parentDsl, arg1, arg2, key) },
                    nonNullKey
                )
            )
        }
    }
}