package com.hotelmanagement.service;

import com.hotelmanagement.constants.CustomerType;
import com.hotelmanagement.constants.Hotel;
import com.hotelmanagement.model.Date;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinimumPriceCalculator {
    public int getMinimumPrice(CustomerType customerType, List<Date> dateList) {
        List<Integer> partitionCountList = createPartition(dateList);
        PricingService pricingService;
        Map<Hotel, Integer> weekDayPriceMap;
        Map<Hotel, Integer> weekEndPriceMap;
        if (customerType.equals(CustomerType.REGULAR)) {
            pricingService = new RegularPricingService();
            weekDayPriceMap = pricingService.getWeekDayPrice(partitionCountList.get(0));
            weekEndPriceMap = pricingService.getWeekEndPrice(partitionCountList.get(1));
        } else {
            pricingService = new RewardedPricingService();
            weekDayPriceMap = pricingService.getWeekDayPrice(partitionCountList.get(0));
            weekEndPriceMap = pricingService.getWeekEndPrice(partitionCountList.get(1));
        }

        return pricingService.getTotalPrice(weekDayPriceMap, weekEndPriceMap);
    }

    private List<Integer> createPartition(List<Date> dateList) {
        List<Integer> partitionCountList = new ArrayList<>();
        int weekDayCount = (int) dateList.stream()
                .filter(date -> !(date.getWeekDay()
                        .equals(DayOfWeek.SATURDAY) || date.getWeekDay().equals(DayOfWeek.SUNDAY)))
                .count();

        int weekEndCount = (int) dateList
                .stream()
                .filter(date -> date.getWeekDay().equals(DayOfWeek.SATURDAY)
                        || date.getWeekDay().equals(DayOfWeek.SUNDAY)).count();

        partitionCountList.add(weekDayCount);
        partitionCountList.add(weekEndCount);

        return partitionCountList;
    }
}
