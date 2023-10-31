package com.example.kmm.android

import android.app.Application
import platform.PlatformConfiguration

//aka PlayzoneApp
class KmpApplication: Application() {
    override fun onCreate(){
        super.onCreate()

        initPlatformSDK()
    }
}

fun KmpApplication.initPlatformSDK() =
    PlatformSDK.initKoin(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )