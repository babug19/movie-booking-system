package com.movie.booking.dto;


import lombok.Data;

@Data
public class MovieRequest {
    private String name;
    private String language;
    private String genre;
}
