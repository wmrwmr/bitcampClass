package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		// 결과 데이터 필요 없다!
		// request 속성에 저장 X
		return "/WEB-INF/views/member/loginform.jsp";
	}

}
