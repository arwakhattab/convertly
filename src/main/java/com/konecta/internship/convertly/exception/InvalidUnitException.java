package com.konecta.internship.convertly.exception;

public class InvalidUnitException extends RuntimeException {
    public InvalidUnitException() {

    }

    public InvalidUnitException(String message) {
        super(message);
    }
}
