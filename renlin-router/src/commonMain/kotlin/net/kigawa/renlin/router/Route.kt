package net.kigawa.renlin.router

class Route(private val path: String) {
    fun isMach(path: String): Boolean {
        return this.path == path
    }
}