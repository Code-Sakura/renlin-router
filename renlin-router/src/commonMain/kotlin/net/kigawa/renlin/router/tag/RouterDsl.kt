package net.kigawa.renlin.router.tag

import net.kigawa.renlin.category.ContentCategory
import net.kigawa.renlin.dsl.Dsl
import net.kigawa.renlin.dsl.DslBase
import net.kigawa.renlin.element.TagNode

class RouterDsl<DSL: Dsl<*>>: DslBase<ContentCategory>() {
  override fun applyElement(element: TagNode) {
  }
}