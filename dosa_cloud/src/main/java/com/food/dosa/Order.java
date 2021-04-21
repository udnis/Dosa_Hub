package com.food.dosa;


import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
	
	
	@NotEmpty(message = "Field can't be empty!")
	@Size(min = 5)
	private String name;
	@NotBlank(message = "Street cannot be required") 
	private String street;
	 @NotBlank(message = "City cannot be required") 
	 private String city;
	 @NotBlank(message = "State cannot be required") 
	 private String state;
	 @NotBlank(message = "Zip cannot be required") 
	 private String zip;
	 @CreditCardNumber 
	 private String ccNumber;
	 @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message ="Must be formatted MM/YY") 
	 private String ccExpiration;
	 @Digits(integer=3 , fraction = 0,message = "Must be 3 digit") 
	 private String ccCVV;
	 
}
