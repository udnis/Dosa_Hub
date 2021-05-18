package com.food.dosa;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
@AllArgsConstructor						//This class stores all the Dosa Design Prototypes
public class DosaPrototype {
	
	private Long id;
	
	private Date createdAt;
	@NotNull
	@Size(min = 5 , message = "Name must be atleast 5 character long")
	private String name;
	@Size(min = 1 , message = "You must choose atleast one Ingredient")
	private List<Ingredient> prototypeIngredient ; 

}
