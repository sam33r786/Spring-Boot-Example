package com.sjahangir.springboottestjpa.controllers.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message) {
        super(message);
    }
}
