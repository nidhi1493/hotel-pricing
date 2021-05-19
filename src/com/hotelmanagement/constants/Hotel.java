package com.hotelmanagement.constants;

public enum Hotel {
    RADISSON(3),
    TAJ(2),
    OYO(4);

    private int rating;

    private Hotel(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

}
