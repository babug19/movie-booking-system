package com.movie.booking.service;

import com.movie.booking.discount.ThirdTicketDiscount;
import com.movie.booking.entity.Booking;
import com.movie.booking.entity.Seat;
import com.movie.booking.entity.Show;
import com.movie.booking.exceptions.CustomException;
import com.movie.booking.notification.NotificationService;
import com.movie.booking.repository.BookingRepository;
import com.movie.booking.repository.SeatRepository;
import com.movie.booking.repository.ShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ThirdTicketDiscount thirdTicketDiscount;
    private final NotificationService notificationService;

    @Transactional
    public String bookTickets(Long showId, List<Long> seatIds, String userId) {

        List<Seat> seats = seatRepository.findAllById(seatIds);

        if(seats.isEmpty()) {
            throw new CustomException("No seats Available");
        }

        double totalAmount = 0;

        for (Seat seat : seats) {
            if (seat.isBooked()) {
                throw new CustomException("Seat already booked");
            }
            seat.setBooked(true);
            totalAmount += seat.getPrice();
        }
        Show show = showRepository.findById(showId).orElseThrow();

        totalAmount = thirdTicketDiscount.apply(show, seats, totalAmount);

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShow(showRepository.findById(showId).orElseThrow());
        booking.setSeatCount(seatIds.size());
        booking.setTotalAmount(totalAmount);
        Booking savedBooking =  bookingRepository.save(booking);

        notificationService.notifyUser(
                userId,
                "Successfully booked tickets. Booking ID: " + savedBooking.getId()
        );

        return "success";
    }



}
