package com.bitcamp.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeaderCheckController {

	@RequestMapping("/header/check")
	public void check(
			ModelMap map,
			Model model,
			ModelAndView mv,
			Map<String, Object> hmap,
			@RequestHeader("referer") String referer
			) {
	
		System.out.println("referer : " + referer);
		map.put("url", referer);
		model.addAttribute("url1", referer);
		mv.addObject("url2", referer);
		hmap.put("url3", referer);
	}
	
}
