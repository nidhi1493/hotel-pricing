package com.hotelmanagement.service;

import com.hotelmanagement.constants.Hotel;
import com.hotelmanagement.constants.RewardedPricing;

import java.util.HashMap;
import java.util.Map;

public class RewardedPricingService extends PricingService {

    @Override
    public Map<Hotel, Integer> getWeekEndPrice(int weekEndCount) {
        Map<Hotel, Integer> pricingMap = new HashMap<>();
        for (RewardedPricing rewardedPricing : RewardedPricing.values()) {
            int price = rewardedPricing.getWeekendPrice() * weekEndCount;
            pricingMap.put(Hotel.valueOf(rewardedPricing.name()), price);
        }
        return pricingMap;
    }

    @Override
    public Map<Hotel, Integer> getWeekDayPrice(int weekDayCount) {
        Map<Hotel, Integer> pricingMap = new HashMap<>();
        for (RewardedPricing rewardedPricing : RewardedPricing.values()) {
            int price = rewardedPricing.getWeekDayPrice() * weekDayCount;
            pricingMap.put(Hotel.valueOf(rewardedPricing.name()), price);
        }
        return pricingMap;
    }
}
