package net.kigawa.kutil.kutil.api.io.fs

import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.pathString

@Suppress("unused", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual open class KuPath(
    private val path: Path,
) : KuPathCommon() {
    actual companion object {
        actual val separator: String
            get() = File.separator
        val JAVA: KuPath = KuPath(System.getProperty("java.home")).join("bin/java")
    }

    actual constructor(strPath: String) : this(Path(strPath))

    actual fun join(child: String): KuPath {
        return KuPath(path.resolve(child))
    }

    actual fun join(child: KuPath): KuPath {
        return KuPath(path.resolve(child.path))
    }

    actual fun toAbsolute(): KuPath {
        return KuPath(path.toAbsolutePath())
    }

    actual fun strPath(): String {
        return path.pathString
    }

    fun javaPath() = path
    actual fun parent(): KuPath {
        return KuPath(path.parent)
    }

    fun isExists(): Boolean {
        return path.exists()
    }

    actual override fun hashCodeKuPathCommon(): Int {
        return path.hashCode()
    }

    actual override fun equals(other: KuPathCommon): Boolean {
        return other is KuPath && other.path == path
    }
}