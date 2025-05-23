package net.kigawa.renlin.router.sample

import net.kigawa.renlin.category.t
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text

class SampleComponent(
  val name: String,
  val sub: Sub,
) {
  var update: (Int) -> Unit = {}

  // public final val root: Component1<Div, EmptyDsl>
  // public val div: TagComponent1<Div, DivDsl> = TagComponent1<Div, DivDsl>
  val aaaa = div.component {
    p {
    }
  }

  val root = div.component {
    key = "key root"

    div {
      key = "uuid 1"
      text {
        key = "uuid 1-1"
        +"repeat "
      }
    }
    sub.display {
      key = "uuid 2"
    }

    fragment {
      div {
        fragment {
          p {
            t("")
          }
        }
        p {
//                    +"aaaa"
        }
      }
    }
//        fragment {
    sub.display {
      key = "uuid 3"
    }
//        }
    sub.controller {
      key = "uuid 4"
    }
    p {
//            key = "uuid 5"
    }
    sub.test {}
    sub.test1 {}
    sub.test2 {}
  }
}
