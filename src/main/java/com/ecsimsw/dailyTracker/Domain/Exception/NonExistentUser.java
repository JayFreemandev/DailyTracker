package com.ecsimsw.dailyTracker.Domain.Exception;

public class NonExistentUser extends IllegalArgumentException {
    public NonExistentUser() {
        super("Non-existent user");
    }
}
