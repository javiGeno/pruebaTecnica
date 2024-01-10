package com.ejercicio.tecnico;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String URL = "/api/product";

	/*
	 * 
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA) Test 2: petición a las 16:00 del día 14 del producto 35455 para la
	 * brand 1 (ZARA) Test 3: petición a las 21:00 del día 14 del producto 35455
	 * para la brand 1 (ZARA) Test 4: petición a las 10:00 del día 15 del producto
	 * 35455 para la brand 1 (ZARA) Test 5: petición a las 21:00 del día 16 del
	 * producto 35455 para la brand 1 (ZARA)
	 */

	@Test
	void ControlerTest1() throws Exception {

		String brand = "1";
		String datApp = "2020-06-14 10:00:00";
		String product = "35455";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice").param("brand", brand)
				.param("product", product).param("date", datApp)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}
//	{
//	    "brandId": 1,
//	    "startDate": "2020-06-14 00:00:00",
//	    "endDate": "2020-12-31 23:59:59",
//	    "priceList": 1,
//	    "productId": 35455,
//	    "price": 35.5
//	}

	@Test
	void ControlerTest2() throws Exception {

		String brand = "1";
		String datApp = "2020-06-14 16:00:00";
		String product = "35455";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice").param("brand", brand)
				.param("product", product).param("date", datApp)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"));

	}
	
//	{
//	    "brandId": 1,
//	    "startDate": "2020-06-14 15:00:00",
//	    "endDate": "2020-06-14 18:30:00",
//	    "priceList": 2,
//	    "productId": 35455,
//	    "price": 25.45
//	}

	@Test
	void ControlerTest3() throws Exception {

		String brand = "1";
		String datApp = "2020-06-14 21:00:00";
		String product = "35455";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice").param("brand", brand)
				.param("product", product).param("date", datApp)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}
//	{
//	    "brandId": 1,
//	    "startDate": "2020-06-14 00:00:00",
//	    "endDate": "2020-12-31 23:59:59",
//	    "priceList": 1,
//	    "productId": 35455,
//	    "price": 35.5
//	}
	
	@Test
	void ControlerTest4() throws Exception {

		String brand = "1";
		String datApp = "2020-06-15 10:00:00";
		String product = "35455";

		mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice").param("brand", brand)
				.param("product", product).param("date", datApp)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"));
	}

//	{
//	    "brandId": 1,
//	    "startDate": "2020-06-15 00:00:00",
//	    "endDate": "2020-06-15 11:00:00",
//	    "priceList": 3,
//	    "productId": 35455,
//	    "price": 30.5
//	}
	@Test
	void ControlerTest5() throws Exception {

		String brand = "1";
		String datApp = "2020-06-16 21:00:00";
		String product = "35455";

		mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice").param("brand", brand)
				.param("product", product).param("date", datApp)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"));
	}
	

 


}
