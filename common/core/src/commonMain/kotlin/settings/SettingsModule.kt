package settings

import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val settingsModule = module {
    singleOf(::Settings)
}
