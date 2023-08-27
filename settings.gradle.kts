pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMM"
include(":androidApp")
include(":shared")
include(":common:auth")
include(":common:tournaments")
include(":common:games")
include("common:core")