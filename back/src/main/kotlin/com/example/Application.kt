package com.example

import io.ktor.server.engine.*
import io.ktor.server.cio.*

import com.example.plugins.*
import com.example.DBconfig.*

fun main() {

    initDB()
    embeddedServer(CIO, port = 8000) {
        configureRouting()
    }.start(wait = true)
}