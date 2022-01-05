package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@GetMapping
	public String getLoginForm(
			Model model,
			@RequestHeader(value = "referer", required = false) String url,
			HttpServletRequest request
			) {
		
		model.addAttribute("url", url==null?"http://localhost:8080"+ request.getContextPath():url);
		
		return "member/loginForm";
	}
	
	@PostMapping
	public String login(
			String uid,
			String pw,
			String url,
			String uname
			) {
		
		System.out.println("uid : " + uid);
		System.out.println("pw : " + pw);
		System.out.println("url : " + url);
		System.out.println("uname : " + uname);
		
		//return "redirect:"+url; // URL 을 받아서 처리
		//return "redirect:/cookie/make";  // 서버 Root 기준의 절대 경로 설정
		return "redirect:reg";	// 현재 경로 기준으로 상대 경로 설정
		
		
	}

}
 