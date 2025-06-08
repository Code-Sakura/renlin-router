package net.kigawa.renlin.router.route.tag

import net.kigawa.kutil.kutil.api.io.fs.KuPath
import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.element.TagNode
import net.kigawa.renlin.router.route.provider.RouterProvider

class RouterDsl<CONTENT_CATEGORY : ContentCategory>(private val routerProvider: RouterProvider) : DslBase<CONTENT_CATEGORY>() {
    override fun applyElement(element: TagNode) {
    }
    val routePath: KuPath
        get() = routerProvider.path.value
}