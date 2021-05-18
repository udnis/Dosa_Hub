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

import com.food.dosa.Ingredient.Type;

//import com.food.dosa.Ingredients.Type;

/**
 * @author sand
 *
 */
@Controller
@RequestMapping("/design")
public class DosaDesignController {
	
	private final IngredientRepository ingredientRepository;
	
	public DosaDesignController(IngredientRepository ingredientRepository) {
		this.ingredientRepository=ingredientRepository;
	}
	public List<Ingredient> filterByType(Type type, List<Ingredient>list) { 		//Return all the ingredients type //name and its id
		
		List <Ingredient> typeList = new ArrayList<Ingredient>();
		for(Ingredient ing:list) {
			if(ing.getType().equals(type)) {
				typeList.add(ing);
			}
		}
		return typeList;		
	}
	@GetMapping
	public String selectDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		ingredientRepository.findAll().forEach(i -> ingredients.add(i));
				
		for(Type type:Type.values()) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(type,ingredients));
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
