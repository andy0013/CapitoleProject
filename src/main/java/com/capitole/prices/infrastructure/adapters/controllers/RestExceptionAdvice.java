package com.capitole.prices.infrastructure.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capitole.prices.application.PriceByCriteriaResponse;
import com.capitole.prices.infrastructure.exceptions.PriceNotFoundException;

@ControllerAdvice
public class RestExceptionAdvice {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<PriceByCriteriaResponse> handlePriceNotFoundException(PriceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorMessage = "Price not found.";
        return ResponseEntity.notFound().build();
    }
}
