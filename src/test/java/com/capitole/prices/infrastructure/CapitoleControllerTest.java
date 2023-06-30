package com.capitole.prices.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

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
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CapitoleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCaseJavaTest1() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,10,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

    @Test
    public void testCaseJavaTest2() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,16,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

    @Test
    public void testCaseJavaTest3() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,21,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

    @Test
    public void testCaseJavaTest4() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,15,10,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

    @Test
    public void testCaseJavaTest5() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,21,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

    @Test
    public void testCaseJavaTest6() {
        LocalDateTime applicationDate = LocalDateTime.of(2020,06,14,10,30,00);
        Long brandIdentifier = 1L;
        Long productIdentifier = 35455L;

        ResponseEntity<ResponseFindByCriteriaPrice> responseEntity = restTemplate.getForEntity(
                "/prices/findByCriteria?applicationDate={applicationDate}&brandIdentifier={brandIdentifier}&productIdentifier={productIdentifier}",
                ResponseFindByCriteriaPrice.class, applicationDate, brandIdentifier, productIdentifier);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceByCriteriaResponse responseBody = responseEntity.getBody().getData();
        assertThat(responseBody).isNotNull();
    }

}

