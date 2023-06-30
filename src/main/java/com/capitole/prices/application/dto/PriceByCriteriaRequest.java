package com.capitole.prices.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceByCriteriaRequest {

	private LocalDateTime applicationDate;

	private Long brandIdentifier;

	private Long productIdentifier;
}
