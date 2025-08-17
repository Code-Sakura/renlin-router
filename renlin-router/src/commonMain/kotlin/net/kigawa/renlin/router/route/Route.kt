package net.kigawa.renlin.router.route

import net.kigawa.kutil.kutil.api.io.fs.KuPath

data class Route(val path: KuPath) {
    fun isMach(path: KuPath): Boolean {
        return this.path == path
    }
}

fun Route(path: String): Route = Route(KuPath(path))