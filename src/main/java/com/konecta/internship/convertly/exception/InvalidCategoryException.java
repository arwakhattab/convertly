package com.konecta.internship.convertly.exception;

public class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException() {

    }

    public InvalidCategoryException(String message) {
        super(message + ", valid categories are: temperature, length, weight, time");
    }
}
