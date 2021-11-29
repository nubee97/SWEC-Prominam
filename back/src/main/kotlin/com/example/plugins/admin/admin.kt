package com.example.plugins.admin

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

import org.joda.time.DateTime

import com.example.DBconfig.*

import com.example.DBconfig.*

fun Route.adminTest() {

    get("/test"){
        call.respondText("admin test")
    }
}

fun Route.addMovie() {
    get("/add/movie/{movieTitle}/{releaseDate}/{runningTime}/{moviePoster}") {
        transaction {
            db_movie.insert {
                it[movieTitle] = call.parameters["movieTitle"].toString()
                it[releaseDate] = DateTime(call.parameters["releaseDate"])
                it[runningTime] = DateTime(call.parameters["runningTime"])
                it[moviePoster] = call.parameters["moviePoster"].toString()
            }
        }
    }
}

fun Route.deleteMovie() {
    get("/delete/movie/{movieTitle}") {
        transaction {
            db_movie.deleteWhere {
                db_movie.movieTitle eq call.parameters["movieTitle"].toString()
            }
        }
        call.respondText("delete movie")
    }
}

fun Route.modifyMovie() {
    get("/modify/movie/") {
        
    }
}