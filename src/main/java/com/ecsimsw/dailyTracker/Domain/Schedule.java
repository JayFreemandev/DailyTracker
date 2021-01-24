package com.ecsimsw.dailyTracker.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue
    @Column(name ="schedule_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Lob
    private String content;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate localDate;

    private Schedule(){ }

    public static Schedule createSchedule(User user, LocalDate localDate, String content){
        Schedule schedule = new Schedule();
        schedule.user = user;
        schedule.localDate = localDate;
        schedule.content = content;
        return schedule;
    }

    public boolean isDate(LocalDate localDate){
        return this.localDate.equals(localDate);
    }

    @Override
    public String toString() {
        return "{" +
                    "user:" + user.getName() +
                    ", content:" + content +
                    ", localDate:" + localDate +
                '}';
    }
}
