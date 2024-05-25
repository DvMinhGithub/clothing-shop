package com.example.demo.exception;

public class CategoryNameExistException extends RuntimeException {
    public CategoryNameExistException(String msg) {
        super(msg);
    }
}
