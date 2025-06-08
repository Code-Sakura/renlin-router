package net.kigawa.kutil.kutil.api.io.fs

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect open class KuPath(
    strPath: String,
) : KuPathCommon{
    companion object {
        val separator: String
    }

    fun join(child: String): KuPath
    fun join(child: KuPath): KuPath
    fun strPath(): String
    fun toAbsolute(): KuPath
    fun parent(): KuPath
    override fun hashCodeKuPathCommon(): Int
    override fun equals(other: KuPathCommon): Boolean
}