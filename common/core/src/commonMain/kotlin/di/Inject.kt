package di

import org.kodein.di.DirectDI

object Inject {
    private var _di: DirectDI? = null
    val di: DirectDI
        get() = requireNotNull(_di)

    fun createDependencies (tree: DirectDI) {
        _di = tree
    }
}