package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

import com.example.plugins.admin.*
import com.example.plugins.customer.*

fun Application.configureRouting() {

    routing {

        get("/") {
            call.respondText("Test")
        }

        admin()
        customer()
    }
}

fun Routing.admin() {

    route("/admin"){
        adminTest()
    }
}

fun Routing.customer() {

    route("/customer"){

        // for ticketing
        customerTest()
        getMovieList()
        getTheaterList()
        getScheduleList()
        getSeatList()
        addTicket()

        // for cancel ticket
        getTicketList()
        deleteTicket()
    }
}