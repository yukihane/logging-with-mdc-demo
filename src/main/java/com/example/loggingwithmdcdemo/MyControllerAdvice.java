package com.example.loggingwithmdcdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ Exception.class })
    public void handleException(final Exception e) {
        log.error("Error: ", e);
    }
}
