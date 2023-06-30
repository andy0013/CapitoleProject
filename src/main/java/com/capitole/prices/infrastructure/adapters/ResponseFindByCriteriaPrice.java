package com.capitole.prices.infrastructure.adapters;

import com.capitole.prices.application.dto.PriceByCriteriaResponse;
import com.capitole.prices.infrastructure.adapters.controllers.output.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseFindByCriteriaPrice extends Response {

    private PriceByCriteriaResponse data;

}
