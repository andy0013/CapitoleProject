package com.capitole.prices.infrastructure.adapters.controllers.output;

import com.capitole.prices.application.dto.PriceByCriteriaResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseFindByCriteriaPrice extends Response {

    private PriceByCriteriaResponse data;

}
