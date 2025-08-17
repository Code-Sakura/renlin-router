package sample

import net.kigawa.hakate.api.HakateInitializer
import net.kigawa.hakate.api.state.MutableState
import net.kigawa.renlin.component.component
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text
import net.kigawa.renlin.w3c.category.t

interface MarginValue


class Sub {
    val state: MutableState<String> = HakateInitializer().newStateDispatcher().newState("state")

    val display = div.component {
        div {
            t("display")
            div(key = "key display") {
                val value = state.useValue()
                t("display1", key = "key display1")
                div {
                    t("display1-1", key = "key display1-1")
                    p {
                        t("display1-1-1 $value", key = "key display1-1-1")
                        text {
//                        margin = "asd"
                        }
                    }
                }
            }
            div {
                t("display2")
                div {
                    t("display2-1")

                }
            }
            div {
                t("display3")

            }
        }
    }
    val controller = div.component {
        div {
            t("controller")
        }
    }
}