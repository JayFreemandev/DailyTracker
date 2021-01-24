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

    public List<Schedule> search(String userName, String stringDate) {
        User user = getUserByName(userName);
        LocalDate date = parseToLocalDate(stringDate);
        return getDailySchedules(user, date);
    }

    public List<Schedule> searchAll(String userName) {
        User user = getUserByName(userName);
        return user.getScheduleList();
    }

    @Transactional
    public void postNewSchedule(String userName, String stringDate, String content) {
        User user = getUserByName(userName);

        LocalDate date = parseToLocalDate(stringDate);
        Schedule schedule = Schedule.createSchedule(user, date, content);
        user.addSchedule(schedule);

        scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteDailySchedules(String userName, String stringDate) {
        User user = getUserByName(userName);
        LocalDate date = parseToLocalDate(stringDate);

        List<Schedule> dailySchedules = getDailySchedules(user, date);
        for (Schedule schedule : dailySchedules) {
            Schedule toDelete = scheduleRepository.findById(schedule.getId());
            user.getScheduleList().remove(toDelete);
            scheduleRepository.delete(toDelete);
        }
    }

    @Transactional
    public void deleteSchedule(String userName, String stringDate, int scheduleIndex) {
        User user = getUserByName(userName);
        LocalDate date = parseToLocalDate(stringDate);

        List<Schedule> dailySchedules = getDailySchedules(user, date);
        Schedule schedule = scheduleRepository.findById(dailySchedules.get(scheduleIndex).getId());
        user.getScheduleList().remove(schedule);
        scheduleRepository.delete(schedule);
    }

    public User getUserByName(String userName) {
        checkValidUser(userName);
        return userRepository.findByName(userName);
    }

    public List<Schedule> getDailySchedules(User user, LocalDate localDate) {
        return user.getScheduleList().stream()
                .filter(schedule -> schedule.isDate(localDate))
                .collect(Collectors.toList());
    }

    private void checkValidUser(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
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
