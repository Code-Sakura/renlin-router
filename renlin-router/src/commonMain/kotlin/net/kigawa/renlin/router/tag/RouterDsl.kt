package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.element.TagNode
import net.kigawa.renlin.router.provider.RouterProvider

class RouterDsl<CONTENT_CATEGORY : ContentCategory>(private val routerProvider: RouterProvider) : DslBase<CONTENT_CATEGORY>() {
    override fun applyElement(element: TagNode) {
    }
    val routePath: String
        get() = routerProvider.path.value
}