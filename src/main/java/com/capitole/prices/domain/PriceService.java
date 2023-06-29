package com.capitole.prices.domain;


import com.capitole.prices.application.PriceByCriteriaRequest;
import com.capitole.prices.application.PriceByCriteriaResponse;

public interface PriceService {
	
	public PriceByCriteriaResponse findByCriteria(PriceByCriteriaRequest priceByCriteriaRequest);

}
