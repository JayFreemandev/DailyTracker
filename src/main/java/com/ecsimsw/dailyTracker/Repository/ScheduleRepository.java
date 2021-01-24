package com.ecsimsw.dailyTracker.Repository;

import com.ecsimsw.dailyTracker.Domain.Schedule;
import com.ecsimsw.dailyTracker.Domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ScheduleRepository {
    private final EntityManager em;

    public void save(Schedule schedule) {
        if (schedule.getId() != null) {
            em.merge(schedule);
            return;
        }
        em.persist(schedule);
    }

    public List<Schedule> getUserDailySchedule(User user, LocalDate localDate) {
        return user.getScheduleList().stream()
                .filter(schedule -> schedule.isDate(localDate))
                .collect(Collectors.toList());
    }
}
