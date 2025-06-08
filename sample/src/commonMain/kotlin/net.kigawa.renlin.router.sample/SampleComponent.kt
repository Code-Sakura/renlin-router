package net.kigawa.renlin.router.sample

import net.kigawa.renlin.category.t
import net.kigawa.renlin.router.tag.route
import net.kigawa.renlin.router.tag.router
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text

class SampleComponent(
    val name: String,
    val sub: Sub,
) {
    var update: (Int) -> Unit = {}

    val root = div.component {
        key = "key root"

        router().invoke {
            route(Routes.top).invoke {
                p {
                    t("top")
                }
            }
            route(Routes.page).invoke {
                p {
                    t("page")
                }
            }
        }

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
