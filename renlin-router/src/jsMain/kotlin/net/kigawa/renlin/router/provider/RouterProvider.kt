package net.kigawa.renlin.router.provider

import net.kigawa.renlin.router.route.provider.RouterProvider
import net.kigawa.renlin.router.route.provider.RouterProviderCommon

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual interface RouterProvider : RouterProviderCommon {
    actual companion object {
        actual val defaultProvider: RouterProvider
            get() = DomRouterProvider
    }
}