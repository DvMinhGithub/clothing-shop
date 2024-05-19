//package com.example.demo.exception.exceptionHandler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.example.demo.exception.CategoryNameExistException;
//import com.example.demo.exception.CategoryNotFoundException;
//import com.example.demo.model.response.ResponseApi;
//
//@RestControllerAdvice
//@Slf4j
//public class CategoryExceptionHandler {
//    @ExceptionHandler(CategoryNotFoundException.class)
//    public ResponseEntity<?> categoryNotFoundExceptionHandler(CategoryNotFoundException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Category not found", 404), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(CategoryNameExistException.class)
//    public ResponseEntity<?> categoryNameExistExceptionHandler(CategoryNameExistException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Category name already exists", 400), HttpStatus.BAD_REQUEST);
//    }
//}
