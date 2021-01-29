package com.ecsimsw.dailyTracker.Domain.Exception;

public class NonExistentUserException extends IllegalArgumentException {
    public NonExistentUserException() {
        super("NOT_FOUND_USER");
    }
}
