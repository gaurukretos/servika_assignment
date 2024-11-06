package com.technicalassignment.technicalassignment.exceptionhandler;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}