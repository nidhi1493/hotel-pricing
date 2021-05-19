package com.hotelmanagement.constants;

public enum RewardedPricing {
    RADISSON(100, 90),
    TAJ(105, 95),
    OYO(90, 80);

    int weekDayPrice;
    int weekendPrice;

    RewardedPricing(int weekDayPrice, int weekendPrice) {
        this.weekDayPrice = weekDayPrice;
        this.weekendPrice = weekendPrice;
    }

    public int getWeekDayPrice() {
        return weekDayPrice;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }
}
