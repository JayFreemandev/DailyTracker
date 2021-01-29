package com.ecsimsw.dailyTracker.Controller;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Domain.ResponseEntity.Message;
import com.ecsimsw.dailyTracker.Domain.ResponseEntity.ResponseEntityFactory;
import com.ecsimsw.dailyTracker.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/{user}/{date}")
    public ResponseEntity searchSchedule(@PathVariable String user,
                                         @PathVariable String date) {
        List results = scheduleService.search(user, date).stream()
                .map(Schedule::toString)
                .collect(Collectors.toList());
        return ResponseEntityFactory.success(new Message("success", results));
    }

    @GetMapping("/{user}")
    public ResponseEntity searchDaySchedule(@PathVariable String user) {
        String result = scheduleService.searchAll(user).toString();
        return ResponseEntityFactory.success(new Message("success", result));
    }

    @PostMapping("/{user}/{date}")
    public ResponseEntity postSchedule(@PathVariable String user,
                                       @PathVariable String date,
                                       @RequestParam String content) {
        scheduleService.postNewSchedule(user, date, content);
        return ResponseEntityFactory.success(new Message("success"));
    }

    @DeleteMapping("/{user}/{date}/{index}")
    public ResponseEntity deleteSchedule(@PathVariable String user,
                                         @PathVariable String date,
                                         @PathVariable int index) {
        scheduleService.deleteSchedule(user, date, index);
        return ResponseEntityFactory.success(new Message("success"));
    }

    @DeleteMapping("{user}/{date}")
    public ResponseEntity deleteSchedule(@PathVariable String user,
                                         @PathVariable String date) {
        scheduleService.deleteDailySchedules(user, date);
        return ResponseEntityFactory.success(new Message("success"));
    }
}
