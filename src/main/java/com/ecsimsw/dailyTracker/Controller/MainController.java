package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/hello")
    public String hello(){
        return "dailyTracker";
    }

    @GetMapping("/get")
    public String getSchedule(@RequestParam String userName,
                              @RequestParam String localDate){

        return mainService.getSearchedSchedule(userName, localDate).toString();
    }
}
