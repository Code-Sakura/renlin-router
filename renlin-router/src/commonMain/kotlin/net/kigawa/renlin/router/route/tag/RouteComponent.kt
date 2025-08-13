package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.dsl.RegisteredDslData
import net.kigawa.renlin.dsl.StatedDsl
import net.kigawa.renlin.router.route.Route
import net.kigawa.renlin.state.DslState
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.Component1
import net.kigawa.renlin.w3c.category.ContentCategory
import net.kigawa.renlin.w3c.element.TagNode
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class RouteComponent<CONTENT_CATEGORY : ContentCategory>(
    val routerDsl: RouterDsl<CONTENT_CATEGORY>,
    val route: Route,
) :
    Component1<Tag<CONTENT_CATEGORY>, StatedDsl<CONTENT_CATEGORY>> {
    override fun newDsl(dslState: DslState): StatedDsl<CONTENT_CATEGORY> {
        return object : DslBase<CONTENT_CATEGORY>(dslState) {
            override fun applyElement(element: TagNode): () -> Unit {
                return {}
            }
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun render(
        parentDsl: StatedDsl<*>,
        block: StatedDsl<CONTENT_CATEGORY>.() -> Unit, key: String?,
    ) {
        if (!route.isMach(routerDsl.routePath)) return
        val key = key ?: Uuid.random().toString()
        val dslState = parentDsl.dslState.getOrCreateSubDslState(key, this)
        val dsl = newDsl(dslState)
        dsl.block()
        parentDsl.registerSubDsl(RegisteredDslData(dsl, this, {
            render(parentDsl, block, key)
        }, key))
    }

}