package com.capitole.prices.infrastructure.adapters.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitole.prices.domain.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	/**
	 * La implementacion del repository se realizo en base a los fines del ejercicio:
	 * 		- Demostrar dominio de JQPL - Manejo de Streams en el @Service.
	 *
	 * En caso de uso en ambito laboral se debe tener en cuenta coste de performance, memoria,
	 * optimizacion, etc.
	 */
	@Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId " +
		       "AND p.startDate <= :date AND p.endDate >= :date " +
		       "ORDER BY p.priority DESC")
	public List<Price> findTopByBrandIdAndProductIdAndDateOrderByPriorityDesc(@Param("brandId") Long brandId,
																				@Param("productId") Long productId, @Param("date") LocalDateTime date);

}
