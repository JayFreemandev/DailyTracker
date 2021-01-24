package com.ecsimsw.dailyTracker.Service;

import com.ecsimsw.dailyTracker.Domain.Exception.InvalidInputDate;
import com.ecsimsw.dailyTracker.Domain.Exception.NonExistentUser;
import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Domain.User;
import com.ecsimsw.dailyTracker.Repository.ScheduleRepository;
import com.ecsimsw.dailyTracker.Repository.UserRepository;
import jdk.jfr.Category;
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

    public List<Schedule> search(String userName, String stringDate) {
        checkValidUser(userName);

        if (stringDate.equals("all")) {
            return getAllSchedule(userName);
        }

        return getSearchedSchedule(userName, stringDate);
    }

    public List<Schedule> getAllSchedule(String userName) {
        User searchedUser = userRepository.findByName(userName);
        return searchedUser.getScheduleList();
    }

    public List<Schedule> getSearchedSchedule(String userName, String stringDate) {
        User searchedUser = userRepository.findByName(userName);

        LocalDate localDate = parseToLocalDate(stringDate);
        return scheduleRepository.getUserDailySchedule(searchedUser, localDate);
    }

    @Transactional
    public void setNewSchedule(String userName, String stringDate, String content) {
        checkValidUser(userName);

        User searchedUser = userRepository.findByName(userName);

        LocalDate localDate = parseToLocalDate(stringDate);
        Schedule schedule = Schedule.createSchedule(searchedUser, localDate, content);
        searchedUser.addSchedule(schedule);

        scheduleRepository.save(schedule);
    }

    private void checkValidUser(String userName) {
        User searchedUser = userRepository.findByName(userName);
        if (searchedUser == null) {
            throw new NonExistentUser();
        }
    }

    private LocalDate parseToLocalDate(String stringDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            return LocalDate.parse(stringDate, formatter);
        } catch (Exception e) {
            throw new InvalidInputDate();
        }
    }
}
