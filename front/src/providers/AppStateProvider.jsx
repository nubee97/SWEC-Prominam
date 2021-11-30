import { useState, useEffect } from "react";
import AppStateContext from "../contexts/AppStateContext";

const cinemaName = ["대한 극장", "서울 극장", "충무로 극장"];
const dateList = [
  "11/04",
  "11/05",
  "11/06",
  "11/07",
  "11/08",
  "11/09",
  "11/10",
  "11/10",
];
const timeList = [
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
  "08:50/A",
];
const seatList = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"];

const AppStateProvider = ({ children }) => {
  const [movies] = useState([
    {
      url: "images/movie_3.jpg",
      title: "디어 에반 핸슨",
    },
    {
      url: "images/movie_4.jpg",
      title: "프렌치 디스패치",
    },
    {
      url: "images/movie_5.jpg",
      title: "귀멸의 칼날",
    },
    {
      url: "images/movie_1.jpg",
      title: "이터널스",
    },
    {
      url: "images/movie_2.jpg",
      title: "듄",
    },
  ]);
  const [cinema, setCinema] = useState([
    "대한 극장",
    "서울 극장",
    "충무로 극장",
  ]);
  const [dateSchedule, setDateSchedule] = useState([
    "11/04",
    "11/05",
    "11/06",
    "11/07",
    "11/08",
    "11/09",
    "11/10",
    "11/10",
  ]);
  const [timeSchedule, setTimeSchedule] = useState([
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
    "08:50/A",
  ]);
  const [seat, setSeat] = useState([
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "10",
  ]);
  const [ticket, setTicket] = useState([]);

  return (
    <AppStateContext.Provider
      value={{
        movies,
        cinema,
        dateSchedule,
        timeSchedule,
        seat,
        ticket,
      }}
    >
      {children}
    </AppStateContext.Provider>
  );
};

export default AppStateProvider;
