package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping()
    public String searchSchedule(@RequestParam String user,
                                 @RequestParam String date) {
        return scheduleService.search(user, date).toString();
    }

    @GetMapping("/all")
    public String searchDaySchedule(@RequestParam String user) {
        return scheduleService.searchAll(user).toString();
    }

    @PostMapping()
    public void postSchedule(@RequestParam String user,
                             @RequestParam String date,
                             @RequestParam String content) {
        scheduleService.postNewSchedule(user, date, content);
    }

    @DeleteMapping()
    public void deleteSchedule(@RequestParam String user,
                               @RequestParam String date,
                               @RequestParam int index) {
        scheduleService.deleteSchedule(user, date, index);
    }

    @DeleteMapping("/all")
    public void deleteSchedule(@RequestParam String user,
                               @RequestParam String date) {
        scheduleService.deleteDailySchedules(user, date);
    }
}
