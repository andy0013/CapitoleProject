package com.capitole.prices.infrastructure;

import com.capitole.prices.application.PriceByCriteriaRequest;
import com.capitole.prices.application.PriceByCriteriaResponse;
import com.capitole.prices.domain.PriceService;
import com.capitole.prices.infrastructure.adapters.controllers.PriceController;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test de Integracion.
 * Interaccion PriceController con PriceServiceImpl.
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Test
    public void testFindByCriteriaShouldSucceedOk() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.now();
        Long brandIdentifier = 1L;
        Long productIdentifier = 2L;

        PriceByCriteriaResponse expectedResponse = new PriceByCriteriaResponse();
        when(priceService.findByCriteria(any(PriceByCriteriaRequest.class))).thenReturn(expectedResponse);
        mockMvc.perform(get("/prices/findByCriteria")
                .param("applicationDate", applicationDate.toString())
                .param("brandIdentifier", brandIdentifier.toString())
                .param("productIdentifier", productIdentifier.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByCriteriaShouldFailNotFound() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.now();
        Long brandIdentifier = 1L;
        Long productIdentifier = 2L;

        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        when(priceService.findByCriteria(any(PriceByCriteriaRequest.class))).thenThrow(PriceNotFoundException.class);
        mockMvc.perform(get("/prices/findByCriteria")
                .param("applicationDate", applicationDate.toString())
                .param("brandIdentifier", brandIdentifier.toString())
                .param("productIdentifier", productIdentifier.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindByCriteriaShouldFailInvalidRequestParam() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.now();
        Long productIdentifier = 2L;

        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        when(priceService.findByCriteria(any(PriceByCriteriaRequest.class))).thenThrow(PriceNotFoundException.class);
        mockMvc.perform(get("/prices/findByCriteria")
                        .param("applicationDate", applicationDate.toString())
                        .param("productIdentifier", productIdentifier.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
