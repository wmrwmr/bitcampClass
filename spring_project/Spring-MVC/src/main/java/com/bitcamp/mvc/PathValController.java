package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathValController {
	
	// /mvc/names/0 /mvc/names/1 /mvc/names/2 ...
	@RequestMapping("/names/{path}/{no}")
	public String getPage(
			@PathVariable("path") String pathName,
			@PathVariable("no") int index,
			Model model
			) {
		
		System.out.println(pathName);
		
		String[] names = new String[] {"손흥민", "이강인", "케인", "메시"};
		
		model.addAttribute("result", names[index]);
		
		return "path/view";
	}

}
