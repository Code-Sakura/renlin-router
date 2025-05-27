package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.element.TagNode

class RouterDsl<CONTENT_CATEGORY : ContentCategory> : DslBase<CONTENT_CATEGORY>() {
    override fun applyElement(element: TagNode) {
    }
}