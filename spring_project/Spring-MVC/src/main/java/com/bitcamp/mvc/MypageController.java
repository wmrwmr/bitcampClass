package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@RequestMapping("/mypage1")
	public String getMypage1() {
		
		System.out.println("MypageController : getMypage1()");
		return "mypage/mypage";
	}
	
	@RequestMapping("/mypage2")
	public String getMypage2() {
		return "mypage/mypage";
	}
	
	@RequestMapping("/mypage3")
	public String getMypage3() {
		return "mypage/mypage";
	}
	
	@RequestMapping("/help/intro")
	public String getHeplPage() {
		return "mypage/help";
	}

}
