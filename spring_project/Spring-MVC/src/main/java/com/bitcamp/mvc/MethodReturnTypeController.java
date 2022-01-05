package com.bitcamp.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodReturnTypeController {

	@RequestMapping("/return/test1")
	public Model test1(Model model) {
		
		model.addAttribute("msg1", "Model 객체 반환");
		return model; // "return/test1"
	}

	@RequestMapping("/return/test2")
	public ModelMap test2(ModelMap map) {

		// ModelMap map = new ModelMap();
		map.addAttribute("msg2", "ModelMap을 통한 데이터 공유");

		return map; // "return/test2"
	}

	@RequestMapping("/return/test3")
	public Map<String, Object> test3(Map<String, Object> map) {

		// Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg3", "Map 객체를 이용한 데이터 공유");

		return map;
	}

}
