package di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object Inject: KoinComponent {
    inline fun<reified T> instance(): T {
        return get()
    }
}