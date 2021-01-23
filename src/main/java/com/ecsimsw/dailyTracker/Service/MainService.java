package com.ecsimsw.dailyTracker.Service;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Domain.User;
import com.ecsimsw.dailyTracker.Repository.ScheduleRepository;
import com.ecsimsw.dailyTracker.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private static final String dateFormat = "yyyy.MM.dd";
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public List<Schedule> getSearchedSchedule(String userName, String stringDate){
        User searchedUser = userRepository.findByName(userName);
        LocalDate localDate = parseToLocalDate(stringDate);
        scheduleRepository.getUserDailySchedule(searchedUser, localDate);
        return null;
    }

    private LocalDate parseToLocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(stringDate, formatter);
    }
}
