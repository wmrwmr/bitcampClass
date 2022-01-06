package com.bitcamp.mvc.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		System.out.println("AuthCheckInterceptor : preHandle()");
		
		HttpSession session = request.getSession(false);
		
		String url = request.getHeader("referer");
		System.out.println(url);
		
		String url1 = new String(request.getRequestURL());
		System.out.println(url1);
		
		// 로그인 상태 체크
		if(session != null && session.getAttribute("loginInfo") != null) {
			// 로그인 상태다!!!!!
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/member/login?url="+url1);
		
		return false;
	}

	
	
}
