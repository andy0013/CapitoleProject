package com.capitole.prices.domain.ports;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capitole.prices.domain.Price;

public interface PriceRepository {

    public List<Price> findByBrandIdAndProductIdAndDateOrderByPriorityDesc(@Param("brandId") Long brandId,
                                                                           @Param("productId") Long productId, @Param("date") LocalDateTime date);

}
