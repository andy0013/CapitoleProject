package com.capitole.prices.domain.services;


import com.capitole.prices.application.dto.PriceByCriteriaRequest;
import com.capitole.prices.application.dto.PriceByCriteriaResponse;

public interface PriceService {
	
	public PriceByCriteriaResponse findByCriteria(PriceByCriteriaRequest priceByCriteriaRequest);

}
