package com.example.plugins.customer

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

import com.google.gson.Gson
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.datetime
import org.jetbrains.exposed.sql.jodatime.date
import org.jetbrains.exposed.sql.transactions.transaction

import com.example.DBconfig.*
import com.example.DBconfig.movie

fun Route.customerTest() {
    get("/test") {
        call.respondText("customer test")
    }
}

fun Route.getMovieList() {
    get("/get/movie") {
        var res: String = ""
        transaction {
            val ans = ArrayList<movie>()
            for (m in db_movie.selectAll()){
                ans.add(movie(movieTitle = m[db_movie.movieTitle],
                    releaseDate = m[db_movie.releaseDate].toString(),
                    runningTime = m[db_movie.runningTime].toString(),
                    moviePoster = m[db_movie.moviePoster]
                )!!)
            }
            res = Gson().toJson(ans)
        }
        
        call.respond(res)
    }
}

fun Route.getTheaterList() {
    get("/get/theater") {

    }
}

fun Route.getScheduleList() {
    get("/get/schedule") {

    }
}

fun Route.getSeatList() {
    get("/get/seat") {

    }
}

fun Route.addTicket() {
    get("/add/ticket") {

    }
}

fun Route.getTicketList() {
    get("/get/ticket") {

    }
}

fun Route.deleteTicket(){
    get("/delete/ticket") {

    }
}