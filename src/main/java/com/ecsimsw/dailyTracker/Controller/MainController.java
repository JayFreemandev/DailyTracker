package com.ecsimsw.dailyTracker.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    public String hello() {
        return "dailyTracker";
    }
}
