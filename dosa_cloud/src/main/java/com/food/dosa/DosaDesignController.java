package com.food.dosa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Errors;

import com.food.dosa.Ingredients.Type;

//import com.food.dosa.Ingredients.Type;

/**
 * @author sand
 *
 */
@Controller
@RequestMapping("/design")
public class DosaDesignController {
	
	public List<Ingredients> filterByType(Type type, List<Ingredients>list) { 		//Return all the ingredients type //name and its id
		
		List <Ingredients> typeList = new ArrayList<Ingredients>();
		for(Ingredients ing:list) {
			if(ing.getType().equals(type)) {
				typeList.add(ing);
			}
		}
		return typeList;		
	}
	@GetMapping
	public String selectDesignForm(Model model) {
		List<Ingredients> list = new ArrayList<Ingredients>();
		list.add(new Ingredients("OISU",Type.OIL,"sunflower"));
		list.add(new Ingredients("OISE",Type.OIL,"seasame"));
		list.add(new Ingredients("OIGR",Type.OIL,"groundnut"));
		list.add(new Ingredients("BAWH",Type.BATTER,"Wheat"));
		list.add(new Ingredients("BARA",Type.BATTER,"Ragi"));
		list.add(new Ingredients("BARI",Type.BATTER,"Rice"));
		list.add(new Ingredients("SHTR",Type.SHAPE,"Triangle"));
		list.add(new Ingredients("SHSQ",Type.SHAPE,"Square"));
		list.add(new Ingredients("SHCI",Type.SHAPE,"Cirle"));
		
		for(Type type:Type.values()) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(type,list));
		}
		
		
		model.addAttribute("design", new DosaPrototype());
		return "designDosa";
	}
	@PostMapping
	public String processDesign( DosaPrototype dosaPrototype , Errors errors) {
		// We will create the dosa here
		if (errors.hasErrors()) {
			 return "designDosa";
			 }
		System.out.println("Inside orders");
		return "redirect:/orders/placeorder";
	}
}
