package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/show")
    public String searchSchedule(@RequestParam String name,
                                 @RequestParam String date) {
        return scheduleService.search(name, date).toString();
    }

    @GetMapping("/show-all")
    public String searchDaySchedule(@RequestParam String name) {
        return scheduleService.searchAll(name).toString();
    }

    @PostMapping("/post")
    public void postSchedule(@RequestParam String name,
                             @RequestParam String date,
                             @RequestParam String content) {
        scheduleService.postNewSchedule(name, date, content);
    }

    @PostMapping("/delete")
    public void deleteSchedule(@RequestParam String name,
                               @RequestParam String date,
                               @RequestParam int index) {
        scheduleService.deleteSchedule(name, date, index);
    }

    @PostMapping("/delete-all")
    public void deleteSchedule(@RequestParam String name,
                               @RequestParam String date) {
        scheduleService.deleteDailySchedules(name, date);
    }
}
