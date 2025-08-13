package net.kigawa.renlin.router.route.tag

import net.kigawa.kutil.kutil.api.io.fs.KuPath
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.state.DslState
import net.kigawa.renlin.w3c.category.ContentCategory
import net.kigawa.renlin.w3c.element.TagNode

class RouterDsl<CONTENT_CATEGORY : ContentCategory>(
    private val routerProvider: RouterProvider,
    dslState: DslState,
) : DslBase<CONTENT_CATEGORY>(dslState) {
    override fun applyElement(element: TagNode): () -> Unit {
        return {}
    }

    val routePath: KuPath
        get() = routerProvider.path.value
}