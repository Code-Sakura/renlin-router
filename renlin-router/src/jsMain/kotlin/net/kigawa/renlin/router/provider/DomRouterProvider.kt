package net.kigawa.renlin.router.provider

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object DomRouterProvider : RouterProvider {
    private val mutablePath = MutableStateFlow(window.location.pathname)
    override val path: StateFlow<String> = mutablePath.asStateFlow()

    init {
        document.addEventListener("popstate", {
            update()
        })
    }

    private fun update() {
        mutablePath.value = window.location.pathname
    }
}