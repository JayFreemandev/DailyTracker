package com.ecsimsw.dailyTracker.Service;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Domain.User;
import com.ecsimsw.dailyTracker.Repository.ScheduleRepository;
import com.ecsimsw.dailyTracker.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private static final String dateFormat = "yyyy.MM.dd";
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public List<Schedule> getSearchedSchedule(String userName, String stringDate){
        User searchedUser = userRepository.findByName(userName);
        LocalDate localDate = parseToLocalDate(stringDate);
        scheduleRepository.getUserDailySchedule(searchedUser, localDate);
        return null;
    }

    @Transactional
    public void setNewSchedule(String userName, String stringDate, String content){
        User searchedUser = userRepository.findByName(userName);
        LocalDate localDate = parseToLocalDate(stringDate);

        Schedule schedule = Schedule.createSchedule(searchedUser, localDate, content);
        searchedUser.addSchedule(schedule);

        scheduleRepository.save(schedule);
    }

    private LocalDate parseToLocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(stringDate, formatter);
    }
}
