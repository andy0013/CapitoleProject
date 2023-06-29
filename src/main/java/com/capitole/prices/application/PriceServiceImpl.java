package com.capitole.prices.application;

import java.util.Optional;

import com.capitole.prices.infrastructure.adapters.repositories.PriceRepository;
import org.springframework.stereotype.Service;
import com.capitole.prices.domain.Price;
import com.capitole.prices.domain.PriceService;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;

@Service
public class PriceServiceImpl implements PriceService {

	private final PriceRepository priceRepository;

	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public PriceByCriteriaResponse findByCriteria(PriceByCriteriaRequest priceByCriteriaRequest) {
		Optional<Price> optionalPrice = this.priceRepository.findTopByBrandIdAndProductIdAndDateOrderByPriorityDesc(
				priceByCriteriaRequest.getBrandIdentifier(),
				priceByCriteriaRequest.getProductIdentifier(),
				priceByCriteriaRequest.getApplicationDate());
		return optionalPrice.map(PriceByCriteriaResponse::fromDomain).orElseThrow(() ->new PriceNotFoundException());
	}
}
