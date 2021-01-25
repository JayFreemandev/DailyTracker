package com.ecsimsw.dailyTracker.ResponseEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.Charset;

/*
    XXX :: Response 마다 매번 MediaType, HttpHeaders 를 인스턴스 하지 않도록.
     메시지(data) 전송을 원할 때만 create 할 수 있도록 만들었다.
     괜찮은 방법인지 확인이 필요 코드.
 */

public class ResponseEntityFactory {
    private static final HttpHeaders headers;
    private static final MediaType mediaType;
    private static final Message failMessage;
    private static final Message successMessage;

    static {
        mediaType = new MediaType("application", "json",
                Charset.forName("UTF-8"));

        headers = new HttpHeaders();
        headers.setContentType(mediaType);

        failMessage = new Message("fail");
        successMessage = new Message("success");
    }

    public static ResponseEntity fail() {
        return new ResponseEntity(failMessage, headers, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity success() {
        return new ResponseEntity(successMessage, headers, HttpStatus.OK);
    }

    public static ResponseEntity create(Message message) {
        return new ResponseEntity(message, headers, HttpStatus.OK);
    }
}
