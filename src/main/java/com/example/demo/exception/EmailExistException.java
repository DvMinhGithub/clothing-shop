package com.example.demo.exception;

public class EmailExistException extends RuntimeException {
    public EmailExistException(String msg) {
        super(msg);
    }
}
