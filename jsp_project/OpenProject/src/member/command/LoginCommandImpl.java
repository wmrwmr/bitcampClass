package member.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.domain.Member;
import member.service.LoginService;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/member/loginform.jsp";
			 
		} else if(request.getMethod().equals("POST")) {
			
			// Service 클래스 에서 반환한 Member 객체를 확인
			// Member 객체가 null 이 아니다 -> session 속성에 로그인 정보 저장
			// Member 객체가 null 이다 -> "아이디 또는 비밀번호가 틀립니다."
			// SQLException 
			
			boolean loginChk = false;
			String msg = "아이디 또는 비밀번호를 확인해주세요.";
						
			try {
				
				Member member = LoginService.getInstance().login(request, response);
				
				if(member != null) {
					// 로그인 처리! : 로그인 장보를 저장하는 LoginInfo 객체 생성
					request.getSession().setAttribute("loginInfo", member.getLoginInfo());
					msg = "로그인 되었습니다.";
					loginChk = true;
				} 
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				msg = "처리도중 예외가 발생 했습니다. 다시 시도해주세요.";
			}
			
			request.setAttribute("loginChk", loginChk);
			request.setAttribute("msg", msg);
			
			
			view = "/WEB-INF/views/member/login.jsp";
			
		}
		
		return view;
	}

}
