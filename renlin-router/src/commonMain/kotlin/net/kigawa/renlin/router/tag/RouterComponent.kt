package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.StructuredComponent

class RouterComponent<CONTENT_CATEGORY : ContentCategory> :
    StructuredComponent<Tag<CONTENT_CATEGORY>, RouterDsl<CONTENT_CATEGORY>> {
    override fun newDsl(): RouterDsl<CONTENT_CATEGORY> {
        return RouterDsl()
    }
}