package com.capitole.prices.infrastructure.exceptions;

public class PriceNotFoundException extends RuntimeException {

    private final static String EXC_MESSAGE = "Price not found.";

    public PriceNotFoundException(){
        super(EXC_MESSAGE);
    }

}
