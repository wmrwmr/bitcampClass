package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mvc.domain.LoginRequest;

@Controller
public class ParamController {
	
	@RequestMapping("/param")
	public String getForm(Model model) {
		model.addAttribute("title", "회원 로그인 폼");
		return "form/loginForm";
	}
	
	// 사용자 요청 파라미터 받기 : HttpServletRequest 이용
	@RequestMapping(value = "/getParam1", method = RequestMethod.POST)
	public String getParam1(
			HttpServletRequest request,
			Model model
			) {
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		model.addAttribute("uid", uid);
		model.addAttribute("pw", pw);
		
		return "form/loginInfo";
	}
	
	// 사용자 요청 파라미터 받기 : @RequestParam 이용 
	@RequestMapping(value = "/getParam2", method = RequestMethod.POST)
	public String getParam2(
			@RequestParam(name = "uid", defaultValue = "test" ) String uid,
			@RequestParam(name = "pw", required = false) String pw,
			@RequestParam(name = "page", defaultValue = "1") int pageNumber,
			Model model
			) {
	
		System.out.println(uid + ":" + pw);
		
		model.addAttribute("uid", uid);
		model.addAttribute("pw", pw);
		
		return "form/loginInfo";
	}
	
	@RequestMapping(value = "/getParam3", method = RequestMethod.POST)
	public String getParam3(
			@ModelAttribute("loginParam") LoginRequest request
			) {
		
		System.out.println(request);
		
		return "form/loginInfo";
	}
	
	
}
