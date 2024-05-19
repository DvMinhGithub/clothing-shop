package com.example.demo.exception;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(String msg){
        super(msg);
    }
}
