package com.capitole.prices.infrastructure.adapters.controllers;

import com.capitole.prices.application.PriceByCriteriaRequest;
import com.capitole.prices.application.PriceByCriteriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.prices.domain.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("/findByCriteria")
	public ResponseEntity<PriceByCriteriaResponse> getPrice(@RequestBody PriceByCriteriaRequest priceDTO) {
		PriceByCriteriaResponse price = priceService.findByCriteria(priceDTO);
		return ResponseEntity.ok(price);
	}
}
