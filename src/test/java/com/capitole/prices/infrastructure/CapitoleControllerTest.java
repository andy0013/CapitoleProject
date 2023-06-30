package com.capitole.prices.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capitole.prices.application.dto.PriceByCriteriaResponse;
import com.capitole.prices.infrastructure.adapters.controllers.output.ResponseFindByCriteriaPrice;

/**
 * En esta clase ejecutamos los test solicitados en el archivo que corresponde al test.
 * Test de Integracion
 * Debe validar datos del response, ya que va contra nuestros endpoints.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CapitoleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test 1 Solicitado.
     */
    @Test
    public void testCase1FindByCriteriaReturnDataOk() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,10,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
        assertEquals(BigDecimal.valueOf(35.50).setScale(2),responseBody.getPrice());
    }

    /**
     * Test 2 Solicitado.
     */
    @Test
    public void testCase2FindByCriteriaReturnDataOk() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,16,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
        assertEquals(BigDecimal.valueOf(25.45),responseBody.getPrice());
    }

    /**
     * Test 3 Solicitado.
     */
    @Test
    public void testCase3FindByCriteriaReturnDataOk() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,21,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
        assertEquals(BigDecimal.valueOf(35.50).setScale(2),responseBody.getPrice());
    }

    /**
     * Test 4 Solicitado.
     */
    @Test
    public void testCase4FindByCriteriaReturnDataOk() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,15,10,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
        assertEquals(BigDecimal.valueOf(30.50).setScale(2),responseBody.getPrice());
    }

    /**
     * Test 5 Solicitado.
     */
    @Test
    public void testCase5FindByCriteriaReturnDataOk() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,16,21,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
        assertEquals(BigDecimal.valueOf(38.95),responseBody.getPrice());
    }

}

