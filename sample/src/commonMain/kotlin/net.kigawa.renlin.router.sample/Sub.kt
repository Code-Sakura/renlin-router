package net.kigawa.renlin.router.sample

import net.kigawa.hakate.api.HakateInitializer
import net.kigawa.hakate.api.state.MutableState
import net.kigawa.renlin.category.FlowContent
import net.kigawa.renlin.category.FlowPhrasingIntersection
import net.kigawa.renlin.category.PhrasingContent
import net.kigawa.renlin.category.t
import net.kigawa.renlin.tag.div
import net.kigawa.renlin.tag.fragment
import net.kigawa.renlin.tag.p
import net.kigawa.renlin.tag.text

interface MarginValue


class Sub {
    val state: MutableState<String> = HakateInitializer().newStateDispatcher().newState("state")

    val display = div.component {
        t("display")
        key = "uuid aaaaaaaaa"
        div {
            val value = state.useValue()
            key = "key display1 div"
            t("display1", key = "key display1")
            div {
                t("display1-1", key = "key display1-1")
                key = "key display1-1 div"
                p {
                    t("display1-1-1 $value", key = "key display1-1-1")
                    key = "key display1-1-1 p"
                    text {
//                        margin = "asd"
                    }
                }
            }
        }
        div {
            t("display2")
            key = "uuid aawaaaaaaaad"
            div {
                t("display2-1")
                key = "uuid aadaaaaaaa"
            }
        }
        div {
            t("display3")
            key = "uuid aawaaaaaaaa"
        }
    }
    val controller = div.component {
        t("controller")
        key = "uuid aaadaadadsaaaa"
    }
    val test = fragment<FlowContent>().component { }
    val test1 = fragment<PhrasingContent>().component { }
    val test2 = fragment<FlowPhrasingIntersection>().component { }
}