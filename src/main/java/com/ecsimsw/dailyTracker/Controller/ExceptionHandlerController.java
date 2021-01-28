package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Domain.Exception.DuplicatedUserException;
import com.ecsimsw.dailyTracker.Domain.Exception.InvalidIndexException;
import com.ecsimsw.dailyTracker.Domain.Exception.InvalidInputDateException;
import com.ecsimsw.dailyTracker.Domain.Exception.NonExistentUserException;
import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler({
            DuplicatedUserException.class,
            InvalidInputDateException.class,
            NonExistentUserException.class,
            InvalidIndexException.class
    })
    public ResponseEntity DefinedExceptionHandler(final Exception e) {
        return ResponseEntityFactory.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity ExceptionHandler(final Exception e) {
        log.info(e.getMessage());
        return ResponseEntityFactory.fail("Undefined error");
    }
}
