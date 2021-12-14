package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginInfo;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 로그인 처리 
		// id==pw -> 로그인 성공 => 결과 boolean loginChk 속성으로 저장
		// 사용자 입력 데이터 받기
		
		// post 요청 시 한글처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		boolean loginChk = false;
		
		// Dao => 회원 정보를 select => 회원 데이터
		
		if(uid.equals(pw)) {
			// 로그인 성공
			loginChk = true;
			
			// 로그인 정보를 저장 : session
			LoginInfo info = new LoginInfo(uid, "손흥민", "SON", "son@gmail.com");
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", info);
			
			
		} else {
			// 로그인 실패
		}
		
		
		// 속성에 결과 저장
		// 결과 페이지에 보여지는 값
		request.setAttribute("loginChk", loginChk);
		
		
		
		
		
		return "/WEB-INF/views/member/login.jsp";
	}

}
