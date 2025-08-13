package net.kigawa.renlin.router.route.tag


import net.kigawa.renlin.w3c.category.ContentCategory

private fun <CONTENT_CATEGORY: ContentCategory>
    RouterDsl<CONTENT_CATEGORY>.routeInternal(): RouteComponent<CONTENT_CATEGORY> {
    return RouteComponent(this)
}

val <CONTENT_CATEGORY: ContentCategory> RouterDsl<CONTENT_CATEGORY>.route get() = routeInternal()