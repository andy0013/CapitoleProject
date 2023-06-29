package com.capitole.prices.infrastructure.adapters.controllers;

import com.capitole.prices.application.PriceByCriteriaRequest;
import com.capitole.prices.application.PriceByCriteriaResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capitole.prices.domain.PriceService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("/findByCriteria")
	public ResponseEntity<PriceByCriteriaResponse> findByCriteria(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
			@RequestParam Long brandIdentifier,
			@RequestParam Long productIdentifier) {
		PriceByCriteriaRequest priceByCriteriaRequest = PriceByCriteriaRequest.builder()
				.applicationDate(applicationDate)
				.brandIdentifier(brandIdentifier)
				.productIdentifier(productIdentifier)
				.build();
		PriceByCriteriaResponse price = priceService.findByCriteria(priceByCriteriaRequest);
		return ResponseEntity.ok(price);
	}
}
