package com.lmcoding.nexttome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform