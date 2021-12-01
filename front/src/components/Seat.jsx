import React from "react";
import useSeat from "../hooks/useSeat";
import { Link } from "react-router-dom";

// css
import "../css/select_seat.css";
import "../css/main.css";

export default function SelectSeat() {
  const seatList = useSeat();

  function addToLocalSeat(seat) {
    localStorage.seat = seat;
  }

  return (
    <section class="box-office">
      <div class="inner">
        <div class="name">
          <h1>좌석 선택</h1>
          <h1 class="SCREEN">SCREEN</h1>
        </div>
      </div>

      <div class="select_seat">
        <div class="seat-alpha">
          <ul>
            <li>A</li>
          </ul>
        </div>
        <div class="seat-number">
          <ul>
            {seatList.map((seat) => {
              return (
                <li>
                  <button
                    onClick={() => {
                      addToLocalSeat(seat);
                    }}
                  >
                    {seat}
                  </button>
                </li>
              );
            })}
          </ul>
        </div>
      </div>
      <Link to="/ticket">
        <button>선택 완료</button>
      </Link>
    </section>
  );
}
