package com.hotelmanagement.service;

import com.hotelmanagement.constants.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class PricingService {
    public abstract Map<Hotel, Integer> getWeekEndPrice(int weekEndCount);

    public abstract Map<Hotel, Integer> getWeekDayPrice(int weekDayCount);

    public int getTotalPrice(Map<Hotel, Integer> weekDayMap, Map<Hotel, Integer> weekEndMap) {
        List<Pair> sortedList = new ArrayList<>();

        int radissonCost = weekDayMap.get(Hotel.RADISSON) + weekEndMap.get(Hotel.RADISSON);
        int tajCost = weekDayMap.get(Hotel.TAJ) + weekEndMap.get(Hotel.TAJ);
        int oyoCost = weekDayMap.get(Hotel.OYO) + weekEndMap.get(Hotel.OYO);

        sortedList.add(new Pair(radissonCost, Hotel.RADISSON.getRating()));
        sortedList.add(new Pair(tajCost, Hotel.TAJ.getRating()));
        sortedList.add(new Pair(oyoCost, Hotel.OYO.getRating()));

        sortedList.sort((p1, p2) -> {
            if (p1.getCost() == p2.getCost()) {
                return p2.getRating() - p1.getRating();
            } else {
                return p1.getCost() - p2.getCost();
            }
        });

        return sortedList.get(0).getCost();
    }

    private static class Pair {
        private final int cost;
        private final int rating;

        public Pair(int cost, int rating) {
            this.cost = cost;
            this.rating = rating;
        }

        public int getCost() {
            return cost;
        }

        public int getRating() {
            return rating;
        }
    }
}
