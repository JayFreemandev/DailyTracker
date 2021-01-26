package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity ExceptionHandler(final Exception e) {
        log.info(e.getMessage());
        return ResponseEntityFactory.fail(e.getMessage());
    }
}
