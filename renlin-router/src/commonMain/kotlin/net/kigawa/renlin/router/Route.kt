package net.kigawa.renlin.router

import net.kigawa.kutil.kutil.api.io.fs.KuPath

class Route(private val path: KuPath) {
    fun isMach(path: KuPath): Boolean {
        return this.path == path
    }
}

fun Route(path: String): Route = Route(KuPath(path))