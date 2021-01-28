package com.ecsimsw.dailyTracker.Domain.Exception;

public class InvalidIndexException extends IllegalArgumentException {
    public InvalidIndexException() {
        super("Invalid index");
    }
}
