package com.bitcamp.mvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/cookie/make")
	public String makeCookie(
			HttpServletResponse response
			) {
		
		response.addCookie(new Cookie("saveId", "cool"));
		
		return "cookie/makeCookie";
	}
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
			@CookieValue(value = "saveId", required = false) String saveId
			) {
		
		System.out.println("saveId + " + saveId);
		
		return "cookie/viewCookie";
	}
	
}
