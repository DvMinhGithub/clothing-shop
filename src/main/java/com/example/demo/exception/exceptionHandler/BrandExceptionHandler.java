//package com.example.demo.exception.exceptionHandler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.example.demo.exception.BrandNameExistException;
//import com.example.demo.exception.BrandNotFoundException;
//import com.example.demo.model.response.ResponseApi;
//
//@RestControllerAdvice
//@Slf4j
//public class BrandExceptionHandler {
//    @ExceptionHandler(BrandNameExistException.class)
//    public ResponseEntity<?> brandNameExistExceptionHandler(BrandNameExistException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Brand name already exist", 400), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(BrandNotFoundException.class)
//    public ResponseEntity<?> brandNotFoundExceptionHandler(BrandNotFoundException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Brand not found", 404), HttpStatus.NOT_FOUND);
//    }
//}
