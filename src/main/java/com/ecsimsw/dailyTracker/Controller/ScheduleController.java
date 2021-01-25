package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.ResponseEntity.Message;
import com.ecsimsw.dailyTracker.ResponseEntity.ResponseEntityFactory;
import com.ecsimsw.dailyTracker.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping()
    public ResponseEntity searchSchedule(@RequestParam String user,
                                         @RequestParam String date) {
        List results = scheduleService.search(user, date);
        Message resMsg = new Message("success", results);
        return ResponseEntityFactory.create(resMsg, HttpStatus.OK);
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
