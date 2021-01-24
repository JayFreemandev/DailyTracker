package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public void createUser(@RequestParam String name) {
        userService.signUp(name);
    }

    @GetMapping("/list")
    public String showUserList() {
        return userService.showUserList().toString();
    }

}
