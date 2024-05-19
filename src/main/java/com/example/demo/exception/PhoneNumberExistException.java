package com.example.demo.exception;

public class PhoneNumberExistException extends RuntimeException{
    public PhoneNumberExistException(String msg){
        super(msg);
    }
}
