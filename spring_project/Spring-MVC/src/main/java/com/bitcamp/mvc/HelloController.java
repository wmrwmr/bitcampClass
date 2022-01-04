package com.bitcamp.mvc;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// HelloService service = new HelloService();
	
	@Autowired
	HelloService service;
	

	// 사용자 요청 uri 등록 : 실행할 메소드를 정의
	// http://localhost:8080/mvc/hello
	@RequestMapping("/hello")
	public ModelAndView hello() {

		ModelAndView view = new ModelAndView();
		// view name 지정
		view.setViewName("hello/hello");
		/* /WEB-INF/views/hello/hello.jsp */
		// view에 전달할 결과 데이터 설정
		view.addObject("greeting", service.getGreetin());

		return view;
	}

	

}
