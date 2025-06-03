package net.kigawa.renlin.router.provider

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual interface RouterProvider : RouterProviderCommon {
    actual companion object {
        actual val defaultProvider: RouterProvider
            get() = object : RouterProvider {
                override val path: StateFlow<String>
                    get() = MutableStateFlow("")
            }
    }
}