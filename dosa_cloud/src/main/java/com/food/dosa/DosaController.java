/**
 * 
 */
package com.food.dosa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sindu
 *
 */
@Controller
@RequestMapping("/")
public class DosaController { 
	@GetMapping("welcome")
	public String dosaWelcome() {
		
		return "dosaWelcome";
	}

}
