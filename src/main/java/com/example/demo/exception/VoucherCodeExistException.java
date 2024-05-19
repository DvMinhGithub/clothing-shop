package com.example.demo.exception;

public class VoucherCodeExistException extends RuntimeException{
    public VoucherCodeExistException(String message) {
        super(message);
    }
}
