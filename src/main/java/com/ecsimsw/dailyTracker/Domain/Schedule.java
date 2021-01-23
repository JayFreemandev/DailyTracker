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

    public boolean isDate(LocalDate localDate){
        return this.localDate.equals(localDate);
    }
}
