package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Domain.ScheduleDTO;
import com.ecsimsw.dailyTracker.Service.ScheduleService;
import com.ecsimsw.dailyTracker.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public void createUser(@RequestParam String userName){
        userService.signUp(userName);
    }

    @GetMapping("/get")
    public String getSchedule(@RequestParam String userName,
                              @RequestParam String localDate){

        return scheduleService.getSearchedSchedule(userName, localDate).toString();
    }

    @PostMapping("/set")
    public void setSchedule(@RequestParam String userName,
                              @RequestParam String localDate,
                              @RequestParam String content){
        scheduleService.setNewSchedule(userName, localDate, content);
    }
}

/*
client=new XMLHttpRequest();
client.open('POST', "http://localhost:8080/set?userName=ecsimsw&localDate=2021.01.23", true);
client.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

client.send('{"content":"sadfl"}');
 */