package com.ecsimsw.dailyTracker.Domain.Exception;

public class InvalidInputDate extends IllegalArgumentException {
    public InvalidInputDate() {
        super("Invalid input date");
    }
}
