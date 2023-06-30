package com.capitole.prices.infrastructure.exceptions;

import com.capitole.prices.infrastructure.adapters.controllers.output.Header;
import com.capitole.prices.infrastructure.adapters.controllers.output.ResponseFindByCriteriaPrice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionAdvice {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ResponseFindByCriteriaPrice> handlePriceNotFoundException(PriceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status)
                .body(ResponseFindByCriteriaPrice.builder()
                    .header(Header.builder()
                    .statusCode(status.value())
                    .errorMessage(ex.getLocalizedMessage())
                    .build())
                .build());
    }
}
