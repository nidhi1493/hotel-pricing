package com.hotelmanagement.constants;

public enum RegularPricing {
    RADISSON(110, 100),
    TAJ(120, 110),
    OYO(130, 90);

    int weekDayPrice;
    int weekendPrice;

    RegularPricing(int weekDayPrice, int weekendPrice) {
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
