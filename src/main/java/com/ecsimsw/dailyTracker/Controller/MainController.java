package com.ecsimsw.dailyTracker.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// TODO :: 상태 코드 반환, @ResponseEntity 공부

// TODO :: 적절한 Http 메소드, URL 컨벤션 공부

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    public String hello() {
        return "dailyTracker";
    }
}
