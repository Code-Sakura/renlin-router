package net.kigawa.renlin.router.route.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.router.route.Route

fun <CONTENT_CATEGORY : ContentCategory>
        RouterDsl<CONTENT_CATEGORY>.route(route: Route): RouteComponent<CONTENT_CATEGORY> {
    return RouteComponent(this, route)
}