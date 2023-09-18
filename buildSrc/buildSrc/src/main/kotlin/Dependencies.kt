object Dependencies {
    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.1.0"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            private const val version = "1.5.31"
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.1"
        }

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.1.1"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Ktor {
        private const val version = "1.6.2"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    }

    object Android {
        private const val version = "7.2.2"
        const val gradlePlugin = "com.android.tools.build:gradle:$version"
    }
}