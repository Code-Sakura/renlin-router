package net.kigawa.renlin.router.route.provider

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual interface RouterProvider : RouterProviderCommon {
    actual companion object {
        actual val defaultProvider: RouterProvider
            get() = DomRouterProvider
    }
}