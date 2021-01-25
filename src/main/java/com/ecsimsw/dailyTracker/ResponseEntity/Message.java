package com.ecsimsw.dailyTracker.ResponseEntity;

public class Message {
    private String message;
    private Object data;

    public Message(String message) {
        this(message, null);
    }

    public Message(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
