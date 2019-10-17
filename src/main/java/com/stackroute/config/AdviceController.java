package com.stackroute.config;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.stackroute")
public class AdviceController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return new ResponseEntity<>("Exception Handled Globally " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = TrackNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(TrackNotFoundException ex) {
        return new ResponseEntity<>("Exception Handled Globally " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<String> exceptionHandler(TrackAlreadyExistsException ex) {
        return new ResponseEntity<>("Exception Handled Globally " + ex.getMessage(), HttpStatus.CONFLICT);
    }

}

