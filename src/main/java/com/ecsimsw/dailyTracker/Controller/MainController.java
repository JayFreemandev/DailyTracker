package com.ecsimsw.dailyTracker.Controller;

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
    public String hello() {
        return "dailyTracker";
    }

    @GetMapping("user/register")
    public void createUser(@RequestParam String name) {
        userService.signUp(name);
    }

    @GetMapping("user/list")
    public String showUserList() {
        return userService.showUserList().toString();
    }

    @GetMapping("schedule/show")
    public String searchSchedule(@RequestParam String name,
                                 @RequestParam String date) {
        return scheduleService.search(name, date).toString();
    }

    @GetMapping("schedule/show-all")
    public String searchDaySchedule(@RequestParam String name) {
        return scheduleService.search(name).toString();
    }

    @PostMapping("schedule/post")
    public void postSchedule(@RequestParam String name,
                             @RequestParam String date,
                             @RequestParam String content) {
        scheduleService.postNewSchedule(name, date, content);
    }

    @PostMapping("schedule/delete")
    public void deleteSchedule(@RequestParam String name,
                               @RequestParam String date,
                               @RequestParam int index) {
        scheduleService.deleteSchedule(name, date, index);
    }
}
