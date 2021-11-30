import React from "react";
import { Link } from "react-router-dom";

import "../css/confirm_movie.css";

export default function Confirm() {
  return (
	<Link to="/confirm">
    <div className="bodybackground">
      <div className="cardWrap">
        <div className="card cardLeft">
          <h1>
            Seanema <span>영화표</span>
          </h1>
          <div className="title">
            <h2>이터널스</h2>
            <span>영화</span>
          </div>
          <div className="name">
            <h2>CGV</h2>
            <span>영화관</span>
          </div>
          <div className="seat">
            <h2>10:00</h2>
            <span>상영시작 시간</span>
          </div>
          <div className="time">
            <h2>12:00</h2>
            <span>상영종료 시간</span>
          </div>
          <div className="theater">
            <h2>상영관 A</h2>
            <span>상영관</span>
          </div>
        </div>
        <div className="card cardRight">
          <div className="eye" />
          <div className="number">
            <h3>156</h3>
            <span>좌석</span>
          </div>
          <div className="barcode" />
        </div>
      </div>
    </div>
	</Link>
  );
}
