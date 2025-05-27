package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.Dsl

val <CONTENT_CATEGORY : ContentCategory>Dsl<CONTENT_CATEGORY>.router: RouterComponent<CONTENT_CATEGORY>
    get() = RouterComponent()