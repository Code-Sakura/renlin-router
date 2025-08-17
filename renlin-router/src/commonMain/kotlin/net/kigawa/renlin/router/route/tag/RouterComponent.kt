package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.component.StructuredComponent
import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.state.DslState
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.w3c.category.ContentCategory

class RouterComponent<CONTENT_CATEGORY: ContentCategory>(
    private val routerProvider: RouterProvider,
): StructuredComponent<Tag<CONTENT_CATEGORY>, CONTENT_CATEGORY, RouterDsl<CONTENT_CATEGORY>> {
    override fun newDsl(dslState: DslState): RouterDsl<CONTENT_CATEGORY> {
        return RouterDsl(routerProvider, dslState)
    }
}