package com.ecsimsw.dailyTracker.Domain.Exception;

public class InvalidInputDateException extends IllegalArgumentException {
    public InvalidInputDateException() {
        super("INVALID_DATE_FORMAT");
    }
}
