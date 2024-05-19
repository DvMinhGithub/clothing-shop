//package com.example.demo.exception.exceptionHandler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.example.demo.exception.EmailExistException;
//import com.example.demo.exception.PhoneNumberExistException;
//import com.example.demo.exception.UserNotFoundException;
//import com.example.demo.model.response.ResponseApi;
//
//@RestControllerAdvice
//@Slf4j
//public class UserExceptionHandler {
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("User not found", 404), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(EmailExistException.class)
//    public ResponseEntity<?> emailExistExceptionHandler(EmailExistException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Email already exist", 400), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(PhoneNumberExistException.class)
//    public ResponseEntity<?> phoneNumberExistExceptionHandler(PhoneNumberExistException ex){
//        log.error(ex.getMessage());
//        return new ResponseEntity<>(new ResponseApi<>("Phone number already exist", 400), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<?> accessDeniedExceptionHandler(AccessDeniedException ex){
//        return new ResponseEntity<>(new ResponseApi<>("Access denied", 403), HttpStatus.FORBIDDEN);
//    }
//}
