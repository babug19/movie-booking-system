package com.movie.booking.service;

import com.movie.booking.entity.Seat;
import com.movie.booking.entity.Show;

import java.util.List;

public interface DiscountStrategy {
    double apply(Show show, List<Seat> seats, double totalAmount);

}
