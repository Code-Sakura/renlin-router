package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.Dsl
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.element.TagNode
import net.kigawa.renlin.router.Route
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.StructuredComponent

class RouteComponent<CONTENT_CATEGORY : ContentCategory>(route: Route) :
    StructuredComponent<Tag<CONTENT_CATEGORY>, Dsl<CONTENT_CATEGORY>> {
    override fun newDsl(): Dsl<CONTENT_CATEGORY> {
        return object : DslBase<CONTENT_CATEGORY>() {
            override fun applyElement(element: TagNode) {
            }
        }
    }
}