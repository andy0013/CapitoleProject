package com.capitole.prices.application.service;

import java.util.List;

import com.capitole.prices.application.dto.PriceByCriteriaRequest;
import com.capitole.prices.application.dto.PriceByCriteriaResponse;
import com.capitole.prices.infrastructure.adapters.repositories.H2PriceRepository;
import org.springframework.stereotype.Service;
import com.capitole.prices.domain.Price;
import com.capitole.prices.domain.services.PriceService;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;

@Service
public class PriceServiceImpl implements PriceService {

	private final H2PriceRepository priceRepository;

	public PriceServiceImpl(H2PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}


	@Override
	public PriceByCriteriaResponse findByCriteria(PriceByCriteriaRequest priceByCriteriaRequest) {
		List<Price> optionalPrice = this.priceRepository.findByBrandIdAndProductIdAndDateOrderByPriorityDesc(
				priceByCriteriaRequest.getBrandIdentifier(),
				priceByCriteriaRequest.getProductIdentifier(),
				priceByCriteriaRequest.getApplicationDate());

		return optionalPrice.stream()
				.findFirst()
				.map(PriceByCriteriaResponse::fromDomain)
				.orElseThrow(() ->new PriceNotFoundException());
	}
}
