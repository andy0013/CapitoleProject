package com.capitole.prices.application;

import org.springframework.stereotype.Service;

import com.capitole.prices.domain.PriceService;

@Service
public class PriceServiceImpl implements PriceService {


	public PriceServiceImpl() {
	}

	@Override
	public PriceByCriteriaResponse findByCriteria(PriceByCriteriaRequest priceDTO) {
		return PriceByCriteriaResponse.builder().build();
	}
}
