package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final ScheduleService scheduleService;

    @GetMapping("/hello")
    public String hello(){
        return "dailyTracker";
    }

    @GetMapping("/get")
    public String getSchedule(@RequestParam String userName,
                              @RequestParam String localDate){

        return scheduleService.getSearchedSchedule(userName, localDate).toString();
    }

    @PostMapping("/set")
    public void setSchedule(@RequestParam String userName,
                              @RequestParam String localDate,
                              @RequestBody String content){
        scheduleService.setNewSchedule(userName, localDate, content);
    }
}


/*
   1. 알고리즘
   2. 운동
   3. 요리
 */