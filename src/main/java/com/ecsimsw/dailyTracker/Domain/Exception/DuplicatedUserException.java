package com.ecsimsw.dailyTracker.Domain.Exception;

public class DuplicatedUserException extends IllegalArgumentException {
    public DuplicatedUserException() {
        super("ALREADY_REGISTERED_USER");
    }
}
