plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                api(project(":common:games:api"))
                api(project(":common:core"))
                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}