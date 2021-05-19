package com.hotelmanagement.model;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

public class Date {
    private final int day;
    private final Month month;
    private final Year year;
    private final DayOfWeek weekDay;

    public Date(int day, Month month, Year year, DayOfWeek weekDay) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekDay = weekDay;
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public Year getYear() {
        return year;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }
}
