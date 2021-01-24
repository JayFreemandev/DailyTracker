package com.ecsimsw.dailyTracker.Service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest {

    @Test
    void dateMatchTest() {
        String dateFormat1 = "yyyy.MM.dd";
        String dateFormat2 = "yyyy-MM-dd";
        String stringDate1= "2021.01.23";
        String stringDate2= "2021-01-23";

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(dateFormat1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(dateFormat2);
        LocalDate l1 = LocalDate.parse(stringDate1, formatter1);
        LocalDate l2 = LocalDate.parse(stringDate2, formatter2);

        assertEquals(true, l1.equals(l2));
    }
}