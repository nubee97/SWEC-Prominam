import React from "react";
import { Link } from "react-router-dom";
import "../css/cinema.css";
import "../css/main.css";
import useCinema from "../hooks/useCinema";

export default function SelectCinema() {
  const cinemaName = useCinema();

  function addToLocatlCinema(cinema) {
    localStorage.cinema = cinema;
  }
  return (
    <section className="box-office">
      <div className="name">
        <h1>영화관 선택</h1>
      </div>
      <div className="inner">
        <div className="select_cinema">
          {cinemaName.map((name) => {
            return (
              <Link
                to="/screen"
                onClick={() => {
                  addToLocatlCinema(name);
                }}
              >
                {name}
              </Link>
            );
          })}
        </div>
      </div>
    </section>
  );
}
