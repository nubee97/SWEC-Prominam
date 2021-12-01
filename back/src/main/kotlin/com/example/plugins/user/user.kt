package com.example.plugins.user

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

fun Route.getUserWithId() {
    get("get/user/{id}") {
        var res: String = ""
        transaction {
            var ans = ArrayList<person>()
            for (p in db_person.selectAll()){
                ans.add(person(
                    personId = p[db_person.personId].toInt(),
                    id = p[db_person.id],
                    pw = p[db_person.pw],
                    email = p[db_person.email],
                    phoneNumber = p[db_person.phoneNumber]
                ))
            }
            res = Gson().toJson(ans)
        }
        call.respond(res)
    }
}

fun Route.addUser() {
    get("/add/user/{id}/{pw}/{email}/{phoneNumber}") {
        transaction {
            db_person.insert {
                it[id] = call.parameters["id"].toString()
                it[pw] = call.parameters["pw"].toString()
                it[email] = call.parameters["email"].toString()
                it[phoneNumber] = call.parameters["phoneNumber"].toString()
            }
        }
        call.respondText("add user")
    }
}

fun Route.checkIdAvailable() {
    get("/check/id/{id}") {
        val flag: Bool = true
        transaction {
            db_person.select {
                (db_person.id.eq(call.parameters["id"].toString()))
            }.forEach {
                flag = false
            }
        }
        if(flag == true){
            call.respondText("1")
        }
        else {
            call.respondText("0")
        }
    }
}

fun Route.deleteUser() {
    get("/delete/user/{id}") {
        transaction {
            db_person.deleteWhere {
                db_person.id eq call.parameters["id"].toString()
            }
        }
        call.respondText("delete user")
    }
}

fun Route.modifyUser() {
    get("/modify/user/{id}/{pw}/{email}/{phoneNumber}") {
        transaction {
            db_person.update ({
                db_person.id eq call.parameters["id"].toString()
            }) {
                it[id] = call.parameters["id"].toString()
                it[pw] = call.parameters["pw"].toString()
                it[email] = call.parameters["email"].toString()
                it[phoneNumber] = call.parameters["phoneNumber"].toString()
            }
        }
        call.respondText("modify user")
    }
}