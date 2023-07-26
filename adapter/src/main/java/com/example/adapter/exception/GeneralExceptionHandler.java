package com.example.adapter.exception;

import org.example.exception.DateFormatNotFitException;
import org.example.exception.InputOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(DateFormatNotFitException.class)
    public ResponseEntity<String> dateFormatNotFitHandler (DateFormatNotFitException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InputOutOfRangeException.class)
    public ResponseEntity<String> inputOutOfRangeException (InputOutOfRangeException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
