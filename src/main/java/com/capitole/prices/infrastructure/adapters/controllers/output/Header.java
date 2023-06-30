package com.capitole.prices.infrastructure.adapters.controllers.output;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {
    private String errorMessage;

    private int statusCode;
}
