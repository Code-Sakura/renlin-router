package net.kigawa.renlin.router.route.tag


import net.kigawa.renlin.router.route.Route
import net.kigawa.renlin.w3c.category.ContentCategory

fun <CONTENT_CATEGORY : ContentCategory>
        RouterDsl<CONTENT_CATEGORY>.route(route: Route): RouteComponent<CONTENT_CATEGORY> {
    return RouteComponent(this, route)
}