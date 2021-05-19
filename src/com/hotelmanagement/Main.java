package com.hotelmanagement;

import com.hotelmanagement.constants.CustomerType;
import com.hotelmanagement.model.Date;
import com.hotelmanagement.service.MinimumPriceCalculator;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MinimumPriceCalculator minimumPriceCalculator = new MinimumPriceCalculator();
        List<Date> dateList = new ArrayList<>();
        Date monday = new Date(18, Month.MAY, Year.now(), DayOfWeek.WEDNESDAY);
        Date thursday = new Date(19, Month.MAY, Year.now(), DayOfWeek.THURSDAY);
        Date saturday = new Date(21, Month.MAY, Year.now(), DayOfWeek.SATURDAY);

        dateList.add(monday);
        dateList.add(thursday);
        dateList.add(saturday);

        int minPrice = minimumPriceCalculator.getMinimumPrice(CustomerType.REGULAR, dateList);
        
        System.out.println("Min Price calculated is " + minPrice);
    }
}
