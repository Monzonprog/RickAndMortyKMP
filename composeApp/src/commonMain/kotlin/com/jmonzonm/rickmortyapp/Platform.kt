package com.jmonzonm.rickmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform