package sample

import net.kigawa.renlin.router.route.RouteGroup

object Routes : RouteGroup() {
    val top = route("/")
    val page = route("/page")
}