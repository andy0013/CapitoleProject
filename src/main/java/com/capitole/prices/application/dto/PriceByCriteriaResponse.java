package com.capitole.prices.application.dto;

import com.capitole.prices.domain.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceByCriteriaResponse {

	private Long productIdentifier;

	private Long brandIdentifier;

	private BigDecimal applicableRate;

	private BigDecimal price;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	public static PriceByCriteriaResponse fromDomain(Price price) {
		return new PriceByCriteriaResponse(price.getProductId(), price.getBrandId(), price.getPriceListEntity().getPriceListApplicableRate(), price.getPrice(), price.getStartDate(), price.getEndDate());
	}

}
