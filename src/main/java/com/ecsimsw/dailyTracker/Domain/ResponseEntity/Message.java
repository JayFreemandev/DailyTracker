package com.ecsimsw.dailyTracker.Domain.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


/*
   XXX :: ResponseEntity Body에 들어가 json으로 변환될 엔티티는 Getter, Setter 필요
   ->  java.lang.IllegalArgumentException: No converter found for return value of type
 */