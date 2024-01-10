package com.ejercicio.tecnico.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.tecnico.dto.PricesOutDTO;
import com.ejercicio.tecnico.service.ProductService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/api/prices")
@Component
public class ProductPricesController {

	@Autowired
	ProductService productService;

	@GetMapping("/getPrice")
	@ResponseBody
	public ResponseEntity<PricesOutDTO> getProductPrice(@RequestParam Long brand, @RequestParam Long product,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {

		PricesOutDTO precioAplicable = productService.getProductPrices(brand, product, date);

		if (precioAplicable != null) {
			return ResponseEntity.ok(precioAplicable);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
