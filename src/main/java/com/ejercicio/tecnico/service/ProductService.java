package com.ejercicio.tecnico.service;

import java.time.LocalDateTime;

import com.ejercicio.tecnico.dto.PricesOutDTO;

public interface ProductService {

	public PricesOutDTO getProductPrices(Long brandId, Long productId, LocalDateTime applyDate);
}
