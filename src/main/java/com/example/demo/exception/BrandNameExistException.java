package com.example.demo.exception;

public class BrandNameExistException extends RuntimeException {
    public BrandNameExistException(String msg) {
        super(msg);
    }
}
