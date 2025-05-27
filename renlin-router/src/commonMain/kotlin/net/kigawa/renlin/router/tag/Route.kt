package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory

val <CONTENT_CATEGORY : ContentCategory>
        RouterDsl<CONTENT_CATEGORY>.route: RouteComponent<CONTENT_CATEGORY>
    get() = RouteComponent()