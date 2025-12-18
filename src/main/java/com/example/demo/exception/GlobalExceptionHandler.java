package com.example.demo.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class) //runtime expection
        public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethod(MethodArgumentNotValidException mex) {
        // Initialize the Map to store field validation errors
        Map<String, String> errors = new HashMap<>();

        // Loop through the field errors and add them to the Map
        mex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()) // Corrected variable name to 'errors'
        );

        // Return the map with validation errors and a BAD_REQUEST status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}