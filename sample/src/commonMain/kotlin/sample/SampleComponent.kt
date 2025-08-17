package sample

import net.kigawa.renlin.component.component
import net.kigawa.renlin.router.route.tag.route
import net.kigawa.renlin.router.route.tag.router
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text
import net.kigawa.renlin.w3c.category.t

class SampleComponent(
    val name: String,
    val sub: Sub,
) {
    var update: (Int) -> Unit = {}

    val root = div.component {

        router().invoke {
            route(Routes.top).invoke {
                div {
                    p {
                        t("top")
                    }
                }
            }
            route(Routes.page).invoke {
                div {
                    p {
                        t("page")
                    }
                }
            }
        }

        div {
            text {
                +"repeat "
            }
        }
        sub.display()

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
        sub.display ()
//        }
        sub.controller ()
        div {
            p {
//            key = "uuid 5"
            }
        }
    }
}
