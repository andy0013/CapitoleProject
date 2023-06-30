package com.capitole.prices.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class PriceByCriteriaRequest {

	private LocalDateTime applicationDate;

	private Long brandIdentifier;

	private Long productIdentifier;
}
