import React, { useState } from "react";
import { Link } from "react-router-dom";
import useDateSchedule from "../hooks/useDate";
import useTimeShedule from "../hooks/useTime";

// css
import "../css/select_screen.css";
import "../css/main.css";

export default function SelectScreen() {
  const dateList = useDateSchedule();
  const timeList = useTimeShedule();

  const [saveDate, setSaveDate] = React.useState("");
  const [saveTime, setSaveTime] = React.useState("");

  const url = localStorage.url;
  const title = localStorage.title;
  const cinema = localStorage.cinema;

  function clickDate(props) {
    setSaveDate(props);
    console.log(saveDate);
  }

  function clickTime(props) {
    setSaveTime(props);
    console.log(saveTime);
  }

  function addToLocalDateAndTime(date, time) {
    localStorage.date = date;
    localStorage.time = time;
  }

  return (
    <section className="box-office">
      <div className="inner">
        <div className="image">
          <img src={url} alt="" width="400px" height="550px" />
          <h1 className="title">{title}</h1>
          <div className="schdule">
            <h1>
              {saveDate} -- {saveTime}
            </h1>
          </div>
        </div>
        <div className="select_screen">
          <div className="name">
            <h1>상영관 및 시간 선택</h1>
          </div>
          <ul className="screen">
            <li className="cinema-screen">영화관</li>
            <li className="cinema-screen-name">{cinema}</li>
          </ul>
          <ul className="screen-date">
            {dateList.map((date) => {
              return (
                <li>
                  <button
                    onClick={() => {
                      clickDate(date);
                    }}
                  >
                    {date}
                  </button>
                </li>
              );
            })}
          </ul>
          <div className="screen-name-box">
            <div className="screen-names">
              <ul className="screen-name">
                {timeList.map((time) => {
                  return (
                    <li>
                      <button
                        onClick={() => {
                          clickTime(time);
                        }}
                      >
                        {time}
                      </button>
                    </li>
                  );
                })}
              </ul>
            </div>
            <div className="screen-names">
              <ul className="screen-name">
                {timeList.map((time) => {
                  return (
                    <li>
                      <button
                        onClick={() => {
                          clickTime(time);
                        }}
                      >
                        {time}
                      </button>
                    </li>
                  );
                })}
              </ul>
            </div>
            <div className="screen-names">
              <ul className="screen-name">
                {timeList.map((time) => {
                  return (
                    <li>
                      <button
                        onClick={() => {
                          clickTime(time);
                        }}
                      >
                        {time}
                      </button>
                    </li>
                  );
                })}
              </ul>
            </div>
          </div>
          <div className="reserve">
            <Link to="/seat">
              <button
                className="btn"
                onClick={() => {
                  addToLocalDateAndTime(saveDate, saveTime);
                }}
              >
                예약하기
              </button>
            </Link>
          </div>
        </div>
      </div>
    </section>
  );
}
