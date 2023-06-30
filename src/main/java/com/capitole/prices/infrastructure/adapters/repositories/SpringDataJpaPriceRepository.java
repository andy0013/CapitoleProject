package com.capitole.prices.infrastructure.adapters.repositories;

import com.capitole.prices.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataJpaPriceRepository extends JpaRepository<Price, Long> {

    /**
     * La implementacion del repository se realizo en base a los fines del ejercicio:
     * 		- Demostrar dominio de JQPL - Manejo de Streams en el @Service.
     *
     * En caso de uso en ambito profesional se debe tener en cuenta coste de performance, memoria,
     * optimizacion, etc.
     *
     * Por ejemplo, delegando la responsabilidad a la query de retornar un unico elemento.
     */
    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId " +
            "AND p.startDate <= :date AND p.endDate >= :date " +
            "ORDER BY p.priority DESC")
    public List<Price> findByBrandIdAndProductIdAndDateOrderByPriorityDesc(@Param("brandId") Long brandId,
                                                                           @Param("productId") Long productId, @Param("date") LocalDateTime date);

}
