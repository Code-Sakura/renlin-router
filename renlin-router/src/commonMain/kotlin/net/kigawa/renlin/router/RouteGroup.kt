package net.kigawa.renlin.router

abstract class RouteGroup {
  var routes: List<Route> = listOf()
    private set
  var groups: List<RouteGroup> = listOf()
    private set


  fun route(path: String) = Route(path).also { routes += it }
  fun subGroup(group: RouteGroup) = group.also { groups += it }
}