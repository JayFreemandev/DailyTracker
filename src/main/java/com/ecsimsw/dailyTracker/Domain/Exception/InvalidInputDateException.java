package com.ecsimsw.dailyTracker.Domain.Exception;

public class InvalidInputDateException extends IllegalArgumentException {
    public InvalidInputDateException() {
        super("Invalid input date");
    }
}
