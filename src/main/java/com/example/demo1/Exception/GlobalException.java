package com.example.demo1.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo1.utill.ResponseStructure;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(PasswordMissmatchError.class)
    public ResponseEntity<ResponseStructure<String>> passwordMissmatcherror(PasswordMissmatchError p) {
        ResponseStructure<String> s = new ResponseStructure<>(HttpStatus.NOT_ACCEPTABLE.value(), p.getMessage(), null, LocalDateTime.now());
        return new ResponseEntity<>(s, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmailallreadyExists.class)
    public ResponseEntity<ResponseStructure<String>> emailAllredayPresent(EmailallreadyExists e) {
        ResponseStructure<String> p = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null, LocalDateTime.now());
        return new ResponseEntity<>(p, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PhoneNumberAllredayExists.class)
    public ResponseEntity<ResponseStructure<String>> phoneNumberAllredyPresent(PhoneNumberAllredayExists p) {
        ResponseStructure<String> c = new ResponseStructure<>(HttpStatus.BAD_GATEWAY.value(), p.getMessage(), null, LocalDateTime.now());
        return new ResponseEntity<>(c, HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(UserNotFoundExcception.class)
    public ResponseEntity<ResponseStructure<String>> userNotFound(UserNotFoundExcception p) {
        ResponseStructure<String> c = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), p.getMessage(), null, LocalDateTime.now());
        return new ResponseEntity<>(c, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStructure<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("Validation error: ");
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        });
        ResponseStructure<String> response = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(), null, LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}