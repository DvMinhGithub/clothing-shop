package com.example.demo.exception;

public class ProductNotAvailableToBuyException extends RuntimeException {
    public ProductNotAvailableToBuyException(String message) {
        super(message);
    }
}
