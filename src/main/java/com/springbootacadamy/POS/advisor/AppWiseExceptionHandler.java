package com.springbootacadamy.POS.advisor;

import com.springbootacadamy.POS.exception.NotFoundException;
import com.springbootacadamy.POS.util.StandaredResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiseExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandaredResponse> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<StandaredResponse>(new StandaredResponse(404,"ERROR",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
