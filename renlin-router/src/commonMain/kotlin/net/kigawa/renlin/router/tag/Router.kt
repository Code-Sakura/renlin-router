package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.Dsl
import net.kigawa.renlin.router.provider.RouterProvider

fun <CONTENT_CATEGORY : ContentCategory> Dsl<CONTENT_CATEGORY>.router(
    routerProvider: RouterProvider = RouterProvider.defaultProvider
): RouterComponent<CONTENT_CATEGORY> {
    return RouterComponent(routerProvider)
}