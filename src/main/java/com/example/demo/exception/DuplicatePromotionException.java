package com.example.demo.exception;

public class DuplicatePromotionException extends RuntimeException{
    public DuplicatePromotionException(String message) {
        super(message);
    }
}
