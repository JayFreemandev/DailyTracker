package com.ecsimsw.dailyTracker.Domain.Exception;

public class DuplicatedUser extends IllegalArgumentException {
    public DuplicatedUser() {
        super("User already exist");
    }
}
