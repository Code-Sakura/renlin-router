package sample

import net.kigawa.hakate.api.HakateInitializer
import net.kigawa.hakate.api.state.MutableState
import net.kigawa.renlin.component.component
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.fragment
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text
import net.kigawa.renlin.w3c.category.integration.FlowPhrasingIntegration
import net.kigawa.renlin.w3c.category.native.FlowContent
import net.kigawa.renlin.w3c.category.native.PhrasingContent
import net.kigawa.renlin.w3c.category.t

interface MarginValue


class Sub {
    val state: MutableState<String> = HakateInitializer().newStateDispatcher().newState("state")

    val display = div.component {
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
    val controller = div.component {

    }
    val test = fragment<FlowContent>().component { }
    val test1 = fragment<PhrasingContent>().component { }
    val test2 = fragment<FlowPhrasingIntegration>().component { }
}