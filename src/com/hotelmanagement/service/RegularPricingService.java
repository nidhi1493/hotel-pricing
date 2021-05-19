package com.hotelmanagement.service;

import com.hotelmanagement.constants.Hotel;
import com.hotelmanagement.constants.RegularPricing;

import java.util.HashMap;
import java.util.Map;

public class RegularPricingService extends PricingService {

    @Override
    public Map<Hotel, Integer> getWeekEndPrice(int weekEndCount) {
        Map<Hotel, Integer> pricingMap = new HashMap<>();
        for (RegularPricing regularPricing : RegularPricing.values()) {
            int price = regularPricing.getWeekendPrice() * weekEndCount;
            pricingMap.put(Hotel.valueOf(regularPricing.name()), price);
        }
        return pricingMap;
    }

    @Override
    public Map<Hotel, Integer> getWeekDayPrice(int weekDayCount) {
        Map<Hotel, Integer> pricingMap = new HashMap<>();
        for (RegularPricing regularPricing : RegularPricing.values()) {
            int price = regularPricing.getWeekDayPrice() * weekDayCount;
            pricingMap.put(Hotel.valueOf(regularPricing.name()), price);
        }
        return pricingMap;
    }
}
