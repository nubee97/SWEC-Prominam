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

import org.joda.time.DateTime

import com.example.DBconfig.*

fun Route.customerTest() {
    get("/test") {
        call.respondText("customer test")
    }
}

fun Route.getMovieList() {
    get("/get/movie") {
        var res: String = ""
        transaction {
            var ans = ArrayList<movie>()
            for (m in db_movie.selectAll()){
                ans.add(movie(
                    movieTitle = m[db_movie.movieTitle],
                    releaseDate = m[db_movie.releaseDate].toString(),
                    runningTime = m[db_movie.runningTime].toString(),
                    moviePoster = m[db_movie.moviePoster]
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.getTheaterList() {
    get("/get/theater") {
        var res: String = ""
        transaction {
            var ans = ArrayList<theater>()
            for (t in db_theater.selectAll()){
                ans.add(theater(
                    theaterName = t[db_theater.theaterName]
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.getScheduleList() {
    get("/get/schedule/{theater}") {
        var res: String = ""
        transaction {
            var ans = ArrayList<schedule>()
            db_schedule.select {
                (db_schedule.theaterName.eq(call.parameters["theater"].toString()))
            }.forEach {
                ans.add(schedule( 
                    movieTitle = it[db_schedule.movieTitle],
                    theaterName = it[db_schedule.theaterName],
                    screenName = it[db_schedule.screenName],
                    startTime = it[db_schedule.startTime].toString(),
                    endTime = it[db_schedule.endTime].toString()
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.getSeatList() {
    get("/get/seat/{theater}/{screen}") {
        var res: String = ""
        transaction {
            var ans = ArrayList<seatinfo>()
            db_seatinfo.select {
                (db_seatinfo.theaterName.eq(call.parameters["theater"].toString())) and
                (db_seatinfo.screenName.eq(call.parameters["screen"].toString()))
            }.forEach {
                ans.add(seatinfo(
                    theaterName = it[db_seatinfo.theaterName],
                    screenName = it[db_seatinfo.screenName],
                    seatrow = it[db_seatinfo.seatrow],
                    seatcol = it[db_seatinfo.seatcol]
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.checkSeatAvailable() {
    get("/check/seat/{movieTitle}/{theaterName}/{screenName}/{startTime}") {
        var res: String = ""
        transaction {
            var ans = ArrayList<seatinfo>()
            db_ticket.select {
                (db_ticket.movieTitle.eq(call.parameters["movieTitle"].toString())) and
                (db_ticket.theaterName.eq(call.parameters["theaterName"].toString())) and
                (db_ticket.screenName.eq(call.parameters["screenName"].toString())) and
                (db_ticket.startTime eq DateTime(call.parameters["startTime"]))
            }.forEach {
                ans.add(seatinfo(
                    theaterName = it[db_ticket.theaterName],
                    screenName = it[db_ticket.screenName],
                    seatrow = it[db_ticket.seatrow],
                    seatcol = it[db_ticket.seatcol]
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.addTicket() {
    get("/add/ticket/{personId}/{movieTitle}/{theaterName}/{screenName}/{startTime}/{endTime}/{seatrow}/{seatcol}/{price}/{purchaseDate}") {
        transaction {
            db_ticket.insert {
                it[personId] = call.parameters["personId"].toString().toInt()
                it[movieTitle] = call.parameters["movieTitle"].toString()
                it[theaterName] = call.parameters["theaterName"].toString()
                it[screenName] = call.parameters["screenName"].toString()
                it[startTime] = DateTime(call.parameters["startTime"])
                it[endTime] = DateTime(call.parameters["endTime"])
                it[seatrow] = call.parameters["seatrow"].toString()
                it[seatcol] = call.parameters["seatcol"].toString()
                it[price] = call.parameters["price"].toString().toInt()
                it[purchaseDate] = DateTime(call.parameters["purchaseDate"])
            }
        }
    }
}

fun Route.getTicketList() {
    get("/get/ticket/{personId}") {
        var res: String = ""
        transaction {
            var ans = ArrayList<ticket>()
            db_ticket.select {
                db_ticket.personId eq call.parameters["personId"].toString().toInt()
            }.forEach {
                ans.add(ticket(
                    ticketId = it[db_ticket.ticketId],
                    personId = it[db_ticket.personId],
                    movieTitle = it[db_ticket.movieTitle],
                    theaterName = it[db_ticket.theaterName],
                    screenName = it[db_ticket.screenName],
                    startTime = it[db_ticket.startTime].toString(),
                    endTime = it[db_ticket.endTime].toString(),
                    seatrow = it[db_ticket.seatrow],
                    seatcol = it[db_ticket.seatcol],
                    price = it[db_ticket.price],
                    purchaseDate = it[db_ticket.purchaseDate].toString()
                ))
            }
        }
    }
}

fun Route.deleteTicket(){
    get("/delete/ticket/{ticketId}") {
        transaction {
            db_ticket.deleteWhere{
                db_ticket.ticketId eq call.parameters["ticketId"].toString().toInt()
            }
        }
        call.respondText("delete ticket")
    }
}