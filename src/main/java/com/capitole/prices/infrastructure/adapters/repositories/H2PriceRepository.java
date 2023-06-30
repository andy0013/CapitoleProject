package com.capitole.prices.infrastructure.adapters.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capitole.prices.domain.Price;
import com.capitole.prices.domain.ports.PriceRepository;

@Component
public class H2PriceRepository implements PriceRepository {

    private final SpringDataJpaPriceRepository springDataJpaPriceRepository;


    public H2PriceRepository(SpringDataJpaPriceRepository springDataJpaPriceRepository){
        this.springDataJpaPriceRepository = springDataJpaPriceRepository;
    }

    @Override
    public List<Price> findByBrandIdAndProductIdAndDateOrderByPriorityDesc(Long brandId, Long productId, LocalDateTime date) {
        return this.springDataJpaPriceRepository.findByBrandIdAndProductIdAndDateOrderByPriorityDesc(brandId, productId, date);
    }
}
