package com.example.DBconfig

import com.google.gson.Gson
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.datetime
import org.jetbrains.exposed.sql.jodatime.date
import org.jetbrains.exposed.sql.transactions.transaction

import org.jetbrains.exposed.sql.vendors.currentDialect

fun initDB() {
    val url = "jdbc:mysql://1.238.89.68:3306/cinema"
    val driver = "com.mysql.jdbc.Driver"
    val user = "prominam"
    val password = "0000"
    Database.connect(url, driver, user, password)
}

data class movie(
    val movieTitle: String, 
    val releaseDate: String,
    val runningTime: String, 
    val moviePoster: String
)

object db_movie: Table("MOVIE") {
    val movieTitle = varchar("movieTitle", length = 50) // primary key
    val releaseDate = date("releaseDate")
    val runningTime = datetime("runningTime")
    val moviePoster = varchar("moviePoster", length = 300)
}

data class person(
    val personId: Int,
    val id = String,
    val pw = String,
    val email = String,
    val phoneNumber = String
)

object db_person: Table("PERSON"){
    val personId = integer("personId") // primary key & auto increment
    val id = varchar("id", length = 30)
    val pw = varchar("pw", length = 30)
    val email = varchar("email", length = 30)
    val phoneNumber = varchar("phoneNumber", length = 20)
}

data class schedule(
    val movieTitle: String,
    val theaterName: String,
    val screenName: String,
    val startTime: String,
    val endTime: String
)

object db_schedule: Table("SCHEDULE"){
    val movieTitle = varchar("movieTitle", length = 50)
    val theaterName = varchar("theaterName", length = 30)
    val screenName = varchar("screenName", length = 3)
    val startTime = datetime("startTime")
    val endTime = datetime("endTime")
}

data class ticket(
    val ticketId: Int,
    val personId: Int,
    val movieTitle: String,
    val theaterName: String,
    val screenName: String,
    val startTime: String,
    val endTime: String,
    val seatrow: String,
    val seatcol: String,
    val price: Int,
    val purchaseDate: String
)

object db_ticket: Table("TICKET"){
    val ticketId = integer("ticketId") // primary key & auto increment
    val personId = integer("personId") // multiple key
    val movieTitle = varchar("movieTitle", length = 50) // multiple key
    val theaterName = varchar("theaterName", length = 30) // multiple key
    val screenName = varchar("screenName", length = 3)
    val startTime = datetime("startTime")
    val endTime = datetime("endTime")
    val seatrow = varchar("seatrow", length = 2)
    val seatcol = varchar("seatcol", length = 2)
    val price = integer("price")
    val purchaseDate = datetime("purchaseDate")
}

data class theater(
    val theaterName: String
)

object db_theater: Table("THEATER"){
    val theaterName = varchar("theaterName", length = 30) // primary key
}

data class screeningroom(
    val theaterName: String,
    val screenName: String
)

object db_screeningroom: Table("SCREENINGROOM"){
    val theaterName = varchar("theaterName", length = 30) // primary key
    val screenName = varchar("screenName", length = 3) // primary key
}

data class seatinfo(
    val theaterName: String,
    val screenName: String,
    val seatrow: String,
    val seatcol: String
)

object db_seatinfo: Table("SEATINFO"){
    val theaterName = varchar("theaterName", length = 30) // primary key
    val screenName = varchar("screenName", length = 3) // primary key
    val seatrow = varchar("seatrow", length = 2) // primary key
    val seatcol = varchar("seatcol", length = 2) // primary key
}