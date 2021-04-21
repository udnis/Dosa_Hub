package com.food.dosa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(DosaController.class)
public class DosaControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void contextLoads() throws Exception {
		mvc.perform(get("/welcome"))
		.andExpect(status().isOk())
		.andExpect(view().name("dosaWelcome"))
		//.andExpect(content().string("Welcome"))
		.andDo(print());
		
	}

}
