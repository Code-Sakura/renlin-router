package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.component.Component1
import net.kigawa.renlin.dsl.RegisteredDslData
import net.kigawa.renlin.dsl.StatedDsl
import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.w3c.category.ContentCategory
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class RouterComponent<CONTENT_CATEGORY: ContentCategory>(
    private val routerProvider: RouterProvider,
): Component1<Tag<CONTENT_CATEGORY>, CONTENT_CATEGORY, RouterDsl<CONTENT_CATEGORY>.() -> Unit> {
    override fun render(
        parentDsl: StatedDsl<out CONTENT_CATEGORY>,
        arg1: RouterDsl<CONTENT_CATEGORY>.() -> Unit, key: String?,
    ) {
        @OptIn(ExperimentalUuidApi::class)
        val nonNullKey = key ?: Uuid.random().toString()
        val state = parentDsl.dslState.getOrCreateSubDslState(nonNullKey, this)
        val routerDsl = RouterDsl<CONTENT_CATEGORY>(routerProvider, state)
        routerDsl.arg1()
        parentDsl.registerSubDsl(
            RegisteredDslData(
                routerDsl, this, { render(parentDsl, arg1, key) },
                nonNullKey
            )
        )
    }
}