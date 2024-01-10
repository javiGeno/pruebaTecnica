package com.ejercicio.tecnico.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ejercicio.tecnico.Model.Prices;

public interface ProductDao extends CrudRepository<Prices, Long>{

	
	@Query(value="Select * from PRICES where "
			+ "BRAND_ID=:brandId "
			+ "and PRODUCT_ID=:productId "
			+ "and START_DATE <= :fechaFiltro and END_DATE >= :fechaFiltro order by PRIORITY desc", nativeQuery=true)
	List<Prices> findByBrandIdAndproductIdBetweenDate(@Param("brandId")Long brandId, @Param("productId")Long productId,@Param("fechaFiltro") LocalDateTime fechaFiltro);
	
	

}
