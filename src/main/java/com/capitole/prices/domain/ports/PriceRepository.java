package com.capitole.prices.domain.ports;

import com.capitole.prices.domain.Price;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    public List<Price> findByBrandIdAndProductIdAndDateOrderByPriorityDesc(@Param("brandId") Long brandId,
                                                                           @Param("productId") Long productId, @Param("date") LocalDateTime date);

}
