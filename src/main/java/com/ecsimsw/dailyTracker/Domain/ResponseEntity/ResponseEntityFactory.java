package com.ecsimsw.dailyTracker.Domain.ResponseEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/*
    XXX :: Response 마다 매번 MediaType, HttpHeaders 를 인스턴스 하지 않도록.
     메시지(data) 전송을 원할 때만 create 할 수 있도록 만들었다.
     괜찮은 방법인지 확인이 필요 코드.
 */

public class ResponseEntityFactory {
    private static final HttpHeaders headers;
    private static final ResponseEntity failRes;
    private static final ResponseEntity successRes;

    static {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        failRes = new ResponseEntity(new Message("fail"), headers, HttpStatus.BAD_REQUEST);
        successRes = new ResponseEntity(new Message("success"), headers, HttpStatus.OK);
    }

    public static ResponseEntity fail() {
        return failRes;
    }

    public static ResponseEntity fail(String message) {
        return fail(new Message(message));
    }

    public static ResponseEntity fail(Message message) {
        return create(message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity success() {
        return successRes;
    }

    public static ResponseEntity success(String message) {
        return success(new Message(message));
    }

    public static ResponseEntity success(Message message) {
        return create(message, HttpStatus.OK);
    }

    public static ResponseEntity create(Message message, HttpStatus status) {
        return new ResponseEntity(message, headers, status);
    }
}
