import React from "react";

import "../css/ticket.css";
import "../css/main.css";

export default function Ticket() {
  const currentDate = new Date();
  const ticket = {
    title: `${localStorage.title}`,
    cinema: `${localStorage.cinema}`,
    time: `${localStorage.time}`,
    date: `${localStorage.date}`,
    seat: `${localStorage.seat}`,
  };
  return (
    <section className="box-office">
      <div className="name">
        <h1>정보 확인</h1>
      </div>
      <div className="inner">
        <img
          src={localStorage.url}
          alt="titleImage"
          width="300px"
          height="427.5px"
        ></img>
        <div className="ticket-info">
          <ul>
            <li>
              예매번호 <span>{currentDate.getTime()}</span>
            </li>
            <li>
              영화관 <span>{ticket.cinema}</span>
            </li>
            <li>
              영화명 <span>{ticket.title}</span>
            </li>
          </ul>
          <ul>
            <li>
              상영시간{" "}
              <span>
                {ticket.date}--{ticket.time}
              </span>
            </li>
            <li>상영관</li>
            <li>
              좌석번호 <span>{ticket.seat}</span>
            </li>
          </ul>
        </div>
      </div>
    </section>
  );
}
