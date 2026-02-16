package com.movie.booking.dto;

import lombok.Data;

@Data
public class CreateTheatreRequest {
    private String name;
    private String city;
}