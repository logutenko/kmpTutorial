package com.example.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform