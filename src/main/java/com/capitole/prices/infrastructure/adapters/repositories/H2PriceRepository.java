package com.capitole.prices.infrastructure.adapters.repositories;

import com.capitole.prices.domain.ports.PriceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.capitole.prices.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

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
