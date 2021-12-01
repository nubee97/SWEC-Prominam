## Seanema backend API server


#### build project: `./gradlew build'   
#### run project: './gradlew run'


backend API

login
  - getUserWithId
  get "get/user/{id}"
  get personId where id = id

  - addUser
  get "/add/user/{id}/{pw}/{email}/{phoneNumber}"
  add person

  - checkIdAvailable
  get "/check/id/{id}"
  if id is already exist, return "0" (string), else return "1" (string)

  - deleteUser
  get "/delete/user/{id}"
  delete person where id = id

  - modifyUser
  get "/modify/user/{id}/{pw}/{email}/{phoneNumber}"
  update person where id = id

admin
  - test
  get "/admin/test"
  return "admin test" (string)

  - addMovie
  get "/admin/add/movie/{movieTitle}/{releaseDate}/{runningTime}/{moviePoster}"
  add movie in DB

  - deleteMovie
  get "/admin/delete/movie/{movieTitle}"
  delete movie in DB where movieTitle = movieTitle

  - modifyMovie
  get "/admin/modify/movie/{currentTitle}/{updateTitle}/{releaseDate}/{runningTime}/{moviePoster}"
  update movie in DB where movieTitle = currentTitle

customer
  - test
  get "/customer/test"
  respond text "customer test"

  - getMovieList
  get "/customer/get/movie"
  return all movie (json list)

  - getTheaterList
  get "/customer/get/theater"
  return all theater (json list)

  - getScheduleList
  get "/customer/get/schedule/{theater}"
  return schedule where theaterName = theater (json list)

  - getSeatList
  get "/customer/get/seat/{theater}/{screen}"
  return seatinfo where theaterName = theater and screen = screenName (json list)

  - checkSeatAvailable
  get "/customer/check/seat/{movieTitle}/{theaterName}/{screenName}/{startTime}"
  return all seatinfo where movietitle, theatername, screenname, starttime (json list)
  => 예약되어있는 모든 좌석 return

  - addTicket
  get "/customer/add/ticket/{personId}/{movieTitle}/{theaterName}/{screenName}/{startTime}/{endTime}/{seatrow}/{seatcol}/{price}/{purchaseDate}"
  add ticket in DB
  => post로 바꿀 예정

  - getTicketList
  get "/customer/get/ticket/{personId}"
  get all ticket where personId = personId

  - deleteTicket
  get "/customer/delete/ticket/{ticketId}"
  delete ticket where ticketId = ticketId