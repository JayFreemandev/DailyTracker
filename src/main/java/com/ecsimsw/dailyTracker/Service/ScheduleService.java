package com.ecsimsw.dailyTracker.Service;

import com.ecsimsw.dailyTracker.Domain.Exception.InvalidInputDateException;
import com.ecsimsw.dailyTracker.Domain.Exception.NonExistentUserException;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private static final String dateFormat = "yyyy.MM.dd";
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public List<Schedule> search(String userName) {
        checkValidUser(userName);

        User searchedUser = userRepository.findByName(userName);
        return searchedUser.getScheduleList();
    }

    public List<Schedule> search(String userName, String stringDate) {
        checkValidUser(userName);

        User searchedUser = userRepository.findByName(userName);
        LocalDate localDate = parseToLocalDate(stringDate);
        return getUserDailySchedule(searchedUser, localDate);
    }

    @Transactional
    public void postNewSchedule(String userName, String stringDate, String content) {
        checkValidUser(userName);

        User searchedUser = userRepository.findByName(userName);

        LocalDate localDate = parseToLocalDate(stringDate);
        Schedule schedule = Schedule.createSchedule(searchedUser, localDate, content);
        searchedUser.addSchedule(schedule);

        scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteSchedule(String userName, String stringDate, int scheduleIndex) {
        checkValidUser(userName);

        User user = userRepository.findByName(userName);
        LocalDate localDate = parseToLocalDate(stringDate);

        List<Schedule> schedules = getUserDailySchedule(user, localDate);
        user.getScheduleList().remove(scheduleIndex);
        scheduleRepository.delete(schedules.get(scheduleIndex));
    }

    public List<Schedule> getUserDailySchedule(User user, LocalDate localDate) {
        return user.getScheduleList().stream()
                .filter(schedule -> schedule.isDate(localDate))
                .collect(Collectors.toList());
    }

    private void checkValidUser(String userName) {
        User searchedUser = userRepository.findByName(userName);
        if (searchedUser == null) {
            throw new NonExistentUserException();
        }
    }

    private LocalDate parseToLocalDate(String stringDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            return LocalDate.parse(stringDate, formatter);
        } catch (Exception e) {
            throw new InvalidInputDateException();
        }
    }
}
