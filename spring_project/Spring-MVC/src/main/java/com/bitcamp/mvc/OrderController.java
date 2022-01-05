package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mvc.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderController {

	@GetMapping
	public String getOrderForm() {
		return "order/orderForm";
	}
	
	@PostMapping
	public void order(
			Model model,
			@ModelAttribute("order") OrderCommand order
			) {
		
		
		System.out.println(order);
		
		// order/order
		model.addAttribute("msg", "주문 완료");
	}
	
}
