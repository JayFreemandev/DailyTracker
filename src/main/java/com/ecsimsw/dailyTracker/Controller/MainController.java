package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Service.ScheduleService;
import com.ecsimsw.dailyTracker.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final ScheduleService scheduleService;
    private final UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "dailyTracker";
    }

    @GetMapping("/signUp")
    public String createUser(@RequestParam String userName) {
        if (userService.isExist(userName)) {
            return "Name already exists";
        }
        userService.signUp(userName);
        return "true";
    }

    @GetMapping("/get")
    public String getSchedule(@RequestParam String userName,
                              @RequestParam String localDate) {
        List result = scheduleService.getSearchedSchedule(userName, localDate);
        return result.toString();
    }

    @PostMapping("/set")
    public String setSchedule(@RequestParam String userName,
                              @RequestParam String localDate,
                              @RequestParam String content) {
        if (!userService.isExist(userName)) {
            return "Non-existent user";
        }
        scheduleService.setNewSchedule(userName, localDate, content);
        return "true";
    }
}
