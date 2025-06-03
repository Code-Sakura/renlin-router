package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.Dsl
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.dsl.RegisteredDslData
import net.kigawa.renlin.element.TagNode
import net.kigawa.renlin.router.Route
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.Component1

class RouteComponent<CONTENT_CATEGORY : ContentCategory>(
    val routerDsl: RouterDsl<CONTENT_CATEGORY>,
    val route: Route
) :
    Component1<Tag<CONTENT_CATEGORY>, Dsl<CONTENT_CATEGORY>> {
    override fun newDsl(): Dsl<CONTENT_CATEGORY> {
        return object : DslBase<CONTENT_CATEGORY>() {
            override fun applyElement(element: TagNode) {
            }
        }
    }

    override fun render(
        parentDsl: Dsl<*>,
        block: Dsl<CONTENT_CATEGORY>.() -> Unit
    ) {
        if (!route.isMach(routerDsl.routePath)) return
        val dsl = newDsl()
        dsl.block()
        parentDsl.subDsl(RegisteredDslData(dsl, this) {
            render(parentDsl, block)
        })
    }
}