package com.capitole.prices.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capitole.priceList.domain.PriceList;
import com.capitole.prices.application.dto.PriceByCriteriaRequest;
import com.capitole.prices.application.dto.PriceByCriteriaResponse;
import com.capitole.prices.application.service.PriceServiceImpl;
import com.capitole.prices.domain.Price;
import com.capitole.prices.infrastructure.adapters.repositories.H2PriceRepository;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;

public class PriceServiceImplTest {

    @Mock
    private H2PriceRepository priceRepository;

    private PriceServiceImpl priceService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        priceService = new PriceServiceImpl(priceRepository);
    }

    @Test
    public void testFindByCriteriaReturnsCorrectPriceFromQueryResponse() {

        List<Price> prices = new ArrayList<>();
        prices.add(Price.builder()
                .brandId(10L)
                .startDate(LocalDateTime.of(2023, 6, 1, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priceListEntity(PriceList.builder().priceListApplicableRate(BigDecimal.valueOf(20.00)).build())
                .productId(10L)
                .price(BigDecimal.valueOf(100.00))
                .build());

        prices.add(Price.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2023, 6, 1, 0, 0))
                .endDate(LocalDateTime.of(2023, 6, 30, 23, 59, 59))
                .priceListEntity(PriceList.builder().priceListApplicableRate(BigDecimal.valueOf(40.00)).build())
                .productId(1L)
                .price(BigDecimal.valueOf(50.00))
                .build());

        when(priceRepository.findByBrandIdAndProductIdAndDateOrderByPriorityDesc(
                any(), any(), any()))
                .thenReturn(prices);

        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        PriceByCriteriaResponse response = priceService.findByCriteria(request);

        assertNotNull(response);
        assertEquals(10L, response.getBrandIdentifier());
        assertEquals(10L, response.getProductIdentifier());
    }


    @Test(expected = PriceNotFoundException.class)
    public void testFindByCriteriaThrowsPriceNotFoundWhenEmptyException() {

        when(priceRepository.findByBrandIdAndProductIdAndDateOrderByPriorityDesc(
                any(), any(), any()))
                .thenReturn(new ArrayList<>());

        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        priceService.findByCriteria(request);
    }

}
