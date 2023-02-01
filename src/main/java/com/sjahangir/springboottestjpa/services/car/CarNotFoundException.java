package com.sjahangir.springboottestjpa.services.car;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(final String message) {
        super(message);
    }
}
