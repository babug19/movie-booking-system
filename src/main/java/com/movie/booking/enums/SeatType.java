package com.movie.booking.enums;

public enum SeatType {
    REGULAR(200.0),
    PREMIUM(250.0),
    RECLINER(300.0);

    private final double price;

    SeatType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
