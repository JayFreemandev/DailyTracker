package com.ecsimsw.dailyTracker.Domain.Exception;

public class NonExistentUserException extends IllegalArgumentException {
    public NonExistentUserException() {
        super("Non-existent user");
    }
}
