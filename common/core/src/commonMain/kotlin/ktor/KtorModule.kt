package ktor

import io.ktor.client.HttpClient
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val KtorModule = DI.Module("ktorModule") {
    bind<HttpClient>() with singleton {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(json = instance())
            }

            install(HttpTimeout){
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
        }
    }
}