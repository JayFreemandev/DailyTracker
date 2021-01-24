package com.ecsimsw.dailyTracker.Domain.Exception;

public class DuplicatedUserException extends IllegalArgumentException {
    public DuplicatedUserException() {
        super("User already exist");
    }
}
