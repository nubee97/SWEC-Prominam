import React from "react";
import { Link } from "react-router-dom";
//import hook
import useLogin from "../hooks/useLogin";

//CSS
import "../css/login.css";

export default function Login() {
const login = useLogin()
	return (
		<Link to="/login">
	<div className="wrapper">
	<div className="title-text">
	  <div className="title login">로그인</div>
	  <div className="title signup">회원 가입</div>
	</div>
	<div className="form-container">
	  <div className="slide-controls">
		<input type="radio" name="slide" id="login" defaultChecked />
		<input type="radio" name="slide" id="signup" />
		<label htmlFor="login" className="slide login">로그인</label>
		<label htmlFor="signup" className="slide signup">회원가입</label>
		<div className="slider-tab" />
	  </div>
	  <div className="form-inner">
		<form action="#" className="login">
		  <div className="field">
			<input type="text" placeholder="Email Address" required />
		  </div>
		  <div className="field">
			<input type="password" placeholder="Password" required />
		  </div>
		  <div className="pass-link">
			{/* <a href="#">Forgot password?</a> */}
			<input type="checkbox" defaultChecked="notchecked" name="remember" />아이디 저장
		  </div>
		  <div className="field btn">
			<div className="btn-layer" />
			<input type="submit" defaultValue="Login" />
		  </div>
		  <div className="signup-link">아직 회원 가입 신청? <a href>회원 가입</a></div>
		</form>
		<form action="#" className="signup">
		  <div className="field">
			<input type="text" placeholder="아이디" required />
		  </div>
		  <div className="field">
			<input type="password" placeholder="비밀번호" required />
		  </div>
		  <div className="field">
			<input type="password" placeholder="다시 비밀번호" required />
		  </div>
		  <div className="field">
			<input type="password" placeholder="이메일 주소" required />
		  </div>
		  <div className="field">
			<input type="password" placeholder="은행 계좌번호" required />
		  </div>
		  {/* <div class="field">
					<input type="password" placeholder="Confirm password" required>
				</div> */}
		  <div className="field btn">
			<div className="btn-layer" />
			<input type="submit" defaultValue="가입 신청" />
		  </div>
		</form>
	  </div>
	</div>
  </div>

  </Link>
  );
		

}