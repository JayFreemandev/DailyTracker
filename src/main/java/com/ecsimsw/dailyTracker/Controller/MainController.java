package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.ResponseEntity.Message;
import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntityFactory.success(new Message("hello"));
    }
}