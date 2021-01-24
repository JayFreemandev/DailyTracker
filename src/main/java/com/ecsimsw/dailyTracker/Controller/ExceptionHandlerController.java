package com.ecsimsw.dailyTracker.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(final Exception e) {
        log.info(e.getMessage());
        return e.getMessage();
    }
}
