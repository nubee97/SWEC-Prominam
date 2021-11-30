import "../css/main.css";
import "../css/header.css";
import { Link } from "react-router-dom";

// import Logo from "/images/logo.png";

export default function Header() {
  const logoUrl = "images/logo.png";
  return (
    <header>
      <div className="inner">
        <Link to="/" className="logo">
          <img src={logoUrl} alt="seanema" height="150px" width="300px" />
        </Link>
        <div className="menu">
          <ul className="menu-list">
            <li>
              <a href="javscript:void(0)">로그 아웃</a>
            </li>
            <li>
              <a href="javscript:void(0)">예매 확인</a>
            </li>
          </ul>
        </div>
      </div>
    </header>
  );
}
