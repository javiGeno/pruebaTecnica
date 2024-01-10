package com.ejercicio.tecnico.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejercicio.tecnico.Model.Prices;
import com.ejercicio.tecnico.dao.ProductDao;
import com.ejercicio.tecnico.dto.PricesOutDTO;
import com.ejercicio.tecnico.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	private final Logger LOG = Logger.getLogger("ProductServiceImpl");

	@Override
	public PricesOutDTO getProductPrices(Long brandId, Long productId, LocalDateTime applyDate) {


		List<Prices> p = (ArrayList<Prices>) productDao.findByBrandIdAndproductIdBetweenDate(brandId,
				productId, applyDate);
		LOG.info("ProductService : bbdd: Prices " + p.toString());

		return (p == null || p.isEmpty()) ? null : fillResponse(p);
	}

	private PricesOutDTO fillResponse(List<Prices> p) {
		List<PricesOutDTO> out = new ArrayList<PricesOutDTO>();

		for (Prices price : p) {

			PricesOutDTO preciosOut = new PricesOutDTO();
			preciosOut.setBrandId(price.getBrandId());
			preciosOut.setEndDate(price.getEndDate());
			preciosOut.setStartDate(price.getStartDate());
			preciosOut.setProductId(price.getProductId());
			preciosOut.setPriceList(price.getPriceList());
			preciosOut.setPrice(price.getPrice());

			out.add(preciosOut);

		}

		return out.get(0);
	}

	

}
