package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("GreetingCommandImpl 진입");
		
		// 사용자 요청 처리
		// JDBC, 데이터 분석, 다른 서버의 API 처리
		String str = "안녕하세요";
		
		// 결과 데이터를 request 속성에 저장
		request.setAttribute("result", str);
		
		// View 지정
		String viewPage = "/WEB-INF/views/greeting.jsp";
		
		return viewPage; // viewPage 결로를 반환
	}

}
