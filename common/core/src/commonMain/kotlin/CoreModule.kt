import database.databaseModule
import json.serializationModule
import ktor.ktorModule
import org.koin.dsl.module
import settings.settingsModule

val coreModule = module {
    includes(
        serializationModule,
        databaseModule,
        ktorModule,
        settingsModule
    )
}