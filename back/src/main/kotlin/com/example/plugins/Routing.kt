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

        // move CRUD
        addMovie()
        deleteMovie()
        modifyMovie()
    }
}

fun Routing.customer() {

    route("/customer"){

        customerTest()

        // for ticketing
        getMovieList()
        getTheaterList()
        getScheduleList()
        getSeatList()
        checkSeatAvailable()
        addTicket()

        // for cancel ticket
        getTicketList()
        deleteTicket()
    }
}

// for login
/*fun Routing.User() {

    route("/user"){


    }
}*/