package net.kigawa.renlin.router.route.provider

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect interface RouterProvider : RouterProviderCommon {
    companion object {
        val defaultProvider: RouterProvider
    }
}