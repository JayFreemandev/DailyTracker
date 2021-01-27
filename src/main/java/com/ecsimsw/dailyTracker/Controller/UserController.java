package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.ResponseEntity.Message;
import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import com.ecsimsw.dailyTracker.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestParam String user) {
        userService.signUp(user);
        return ResponseEntityFactory.success("success");
    }

    @GetMapping("/list")
    public ResponseEntity showUserList() {
        String result = userService.showUserList().toString();
        return ResponseEntityFactory.success(new Message("success", result));
    }
}
