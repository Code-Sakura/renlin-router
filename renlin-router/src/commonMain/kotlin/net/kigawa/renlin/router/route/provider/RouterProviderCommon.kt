package net.kigawa.renlin.router.route.provider

import kotlinx.coroutines.flow.StateFlow
import net.kigawa.kutil.kutil.api.io.fs.KuPath

interface RouterProviderCommon {
     val path: StateFlow<KuPath>
}