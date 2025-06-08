package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.StructuredComponent

class RouterComponent<CONTENT_CATEGORY : ContentCategory>(
    private val routerProvider: RouterProvider
) :
    StructuredComponent<Tag<CONTENT_CATEGORY>, RouterDsl<CONTENT_CATEGORY>> {
    override fun newDsl(): RouterDsl<CONTENT_CATEGORY> {
        return RouterDsl(routerProvider)
    }
}