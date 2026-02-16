package com.movie.booking.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookSeatRequest {

    private Long showId;
    private List<Long> seatIds;
    private String userId;
}
