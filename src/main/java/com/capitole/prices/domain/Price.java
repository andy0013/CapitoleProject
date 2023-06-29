package com.capitole.prices.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;


import com.capitole.brand.domain.Brand;
import com.capitole.priceList.domain.PriceList;
import com.capitole.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "price")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand_id")
	private Long brandId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id", insertable = false, updatable = false)
	private Brand brand;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	@Column(name = "price_list")
	private Long priceList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_list", referencedColumnName = "price_list_id", insertable = false, updatable = false)
	private PriceList priceListEntity;

	@Column(name = "product_id")
	private Long productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
	private Product product;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "curr")
	private String curr;
}
