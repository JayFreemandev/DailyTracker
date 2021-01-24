package com.ecsimsw.dailyTracker.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new LinkedList<>();

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    public void addSchedule(Schedule schedule){
        scheduleList.add(schedule);
    }
}
