package net.kigawa.kutil.kutil.api.io.fs

abstract class KuPathCommon {
    override fun equals(other: Any?): Boolean {
        if (other !is KuPathCommon) return false
        return equals(other)
    }

    override fun hashCode(): Int {
        return hashCodeKuPathCommon()
    }

    abstract fun hashCodeKuPathCommon(): Int

    abstract fun equals(other: KuPathCommon): Boolean
}