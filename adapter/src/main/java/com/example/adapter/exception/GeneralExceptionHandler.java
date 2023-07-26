package com.example.adapter.exception;

import org.example.exception.DateFormatNotFit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(DateFormatNotFit.class)
    public ResponseEntity<String> dateFormatNotFitHandler (DateFormatNotFit ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
