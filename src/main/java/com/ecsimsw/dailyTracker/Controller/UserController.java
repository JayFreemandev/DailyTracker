package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void createUser(@RequestParam String user) {
        userService.signUp(user);
    }

    @GetMapping("/list")
    public String showUserList() {
        return userService.showUserList().toString();
    }
}