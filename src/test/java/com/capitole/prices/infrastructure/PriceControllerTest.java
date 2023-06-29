package com.capitole.prices.infrastructure;

import com.capitole.prices.application.PriceByCriteriaRequest;
import com.capitole.prices.application.PriceByCriteriaResponse;
import com.capitole.prices.domain.PriceService;
import com.capitole.prices.infrastructure.adapters.controllers.PriceController;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Test
    public void testFindByCriteriaShouldSucceedOk() throws Exception {
        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        PriceByCriteriaResponse expectedResponse = new PriceByCriteriaResponse();
        when(priceService.findByCriteria(any(PriceByCriteriaRequest.class))).thenReturn(expectedResponse);
        mockMvc.perform(get("/prices/findByCriteria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByCriteriaShouldFailNotFound() throws Exception {
        PriceByCriteriaRequest request = new PriceByCriteriaRequest();
        when(priceService.findByCriteria(any(PriceByCriteriaRequest.class))).thenThrow(PriceNotFoundException.class);
        mockMvc.perform(get("/prices/findByCriteria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isNotFound());
    }

}
