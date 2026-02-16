package com.movie.booking.controller;

import com.movie.booking.dto.BookSeatRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public  BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<String> bookMovie(@RequestBody  BookSeatRequest bookSeatRequest){
        bookingService.bookTickets(bookSeatRequest.getShowId(),bookSeatRequest.getSeatIds(),bookSeatRequest.getUserId());
        return ResponseEntity.ok("Seat booked successfully");
    }
}
