package com.food.dosa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Ingredient {
	
	private  String id;
	private  Type type;
	private  String name;
	
	
	public static enum Type{
		OIL,BATTER,SHAPE
	}
}

