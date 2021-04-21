package com.food.dosa;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/orders")
public class OrderController {
	static {
		System.out.println("Inside orders");
	}
	@GetMapping("/placeorder")
	public String orderForm(Model model ) {
		System.out.println("Inside orders");
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	@PostMapping
	public String place(@Valid Order order , Errors error) {
	//	System.out.println(order.getCcCVV());
		if(error.hasErrors()) {
			System.out.println(error.toString());
			return "orderForm";
		}
		
		
		return "redirect:/design";
	}


}
