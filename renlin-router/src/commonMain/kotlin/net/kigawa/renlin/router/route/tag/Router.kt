package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.dsl.StatedDsl
import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.w3c.category.ContentCategory

fun <CONTENT_CATEGORY : ContentCategory> StatedDsl<CONTENT_CATEGORY>.router(
    routerProvider: RouterProvider = RouterProvider.defaultProvider,
): RouterComponent<CONTENT_CATEGORY> {
    return RouterComponent(routerProvider)
}