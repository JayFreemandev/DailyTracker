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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping()
    public ResponseEntity searchSchedule(@RequestParam String user,
                                         @RequestParam String date) {
        List results = scheduleService.search(user, date).stream()
                .map(Schedule::toString)
                .collect(Collectors.toList());
        return ResponseEntityFactory.success(new Message("success", results));
    }

    @GetMapping("/all")
    public ResponseEntity searchDaySchedule(@RequestParam String user) {
        String result = scheduleService.searchAll(user).toString();
        return ResponseEntityFactory.success(new Message("success", result));
    }

    @PostMapping()
    public ResponseEntity postSchedule(@RequestParam String user,
                                       @RequestParam String date,
                                       @RequestParam String content) {
        scheduleService.postNewSchedule(user, date, content);
        return ResponseEntityFactory.success(new Message("success"));
    }

    @DeleteMapping()
    public ResponseEntity deleteSchedule(@RequestParam String user,
                                         @RequestParam String date,
                                         @RequestParam int index) {
        scheduleService.deleteSchedule(user, date, index);
        return ResponseEntityFactory.success(new Message("success"));
    }

    @DeleteMapping("/all")
    public ResponseEntity deleteSchedule(@RequestParam String user,
                                         @RequestParam String date) {
        scheduleService.deleteDailySchedules(user, date);
        return ResponseEntityFactory.success(new Message("success"));
    }
}
