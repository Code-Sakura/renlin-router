package net.kigawa.renlin.router.provider

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.kigawa.kutil.kutil.api.io.fs.KuPath

object DomRouterProvider : RouterProvider {
    private val mutablePath = MutableStateFlow(KuPath(window.location.pathname))
    override val path: StateFlow<KuPath> = mutablePath.asStateFlow()

    init {
        document.addEventListener("popstate", {
            update()
        })
    }

    private fun update() {
        mutablePath.value = KuPath(window.location.pathname)
    }
}