package net.kigawa.renlin.router.tag

import net.kigawa.renlin.dsl.Dsl
import net.kigawa.renlin.tag.Tag
import net.kigawa.renlin.tag.component.StructuredComponent

class RouterComponent<DSL: Dsl<*>>: StructuredComponent<Tag<*>, RouterDsl<DSL>> {
  override fun newDsl(): RouterDsl<DSL> {
    return RouterDsl()
  }
}