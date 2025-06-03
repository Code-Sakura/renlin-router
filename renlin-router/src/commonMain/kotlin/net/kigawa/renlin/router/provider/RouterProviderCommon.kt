package net.kigawa.renlin.router.provider

import kotlinx.coroutines.flow.StateFlow

interface RouterProviderCommon {
     val path: StateFlow<String>
}