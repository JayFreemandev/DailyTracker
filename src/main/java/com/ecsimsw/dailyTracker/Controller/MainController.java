package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.ResponseEntity.Message;
import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

// TODO :: 상태 코드 반환, @ResponseEntity 공부
// TODO :: 적절한 Http 메소드, URL 컨벤션 공부

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntityFactory.success();
    }
}