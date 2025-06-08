package net.kigawa.kutil.kutil.api.io.fs

@Suppress("unused", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual open class KuPath(
    private val isAbsolute: Boolean,
    private val path: List<String>,

    ) : KuPathCommon() {
    actual constructor(strPath: String) : this(
        strPath.startsWith(separator), strPath.split(separator).filter { it != "" }
    )

    actual companion object {
        actual val separator: String = "/"

    }

    actual fun join(child: String): KuPath {
        return KuPath(isAbsolute, path + child.split(separator).filter { it != "" })
    }

    actual fun join(child: KuPath): KuPath {
        return KuPath(isAbsolute, path + child.path)
    }

    actual fun strPath(): String {
        val prefix = if (isAbsolute) separator else ""
        return path.joinToString(separator = separator, prefix = prefix)
    }

    actual fun toAbsolute(): KuPath {
        return KuPath(true, path)
    }

    actual fun parent(): KuPath {
        if (path.isEmpty()) throw IllegalStateException("path must be root")
        return KuPath(true, path.take(path.size - 1))
    }

    actual override fun hashCodeKuPathCommon(): Int {
        return isAbsolute.hashCode() * path.hashCode()
    }

    actual override fun equals(other: KuPathCommon): Boolean {
        return other is KuPath && other.isAbsolute == isAbsolute && other.path == path
    }
}