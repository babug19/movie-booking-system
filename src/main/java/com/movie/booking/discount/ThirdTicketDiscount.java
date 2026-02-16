package com.movie.booking.discount;

import com.movie.booking.entity.Seat;
import com.movie.booking.entity.Show;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ThirdTicketDiscount implements DiscountStrategy {
    @Override
    public double apply(Show show, List<Seat> seats, double totalAmount) {
        if (seats.size() >= 3) {
            Seat cheapest = seats.stream()
                    .min(Comparator.comparingDouble(Seat::getPrice))
                    .orElseThrow();

            return totalAmount - (cheapest.getPrice() * 0.5);
        }
        return totalAmount;
    }
}
