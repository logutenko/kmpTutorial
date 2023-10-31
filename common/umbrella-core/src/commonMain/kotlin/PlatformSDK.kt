import org.koin.core.context.startKoin
import org.koin.dsl.module
import platform.PlatformConfiguration

object PlatformSDK {
    fun initKoin(
        configuration: PlatformConfiguration
    ) {
        val umbrellaModule = module {
            single {
                configuration
            }
        }

        startKoin {
            modules(
                    umbrellaModule,
                    coreModule,
                    gamesModule,
                    authModule
            )
        }
    }
}