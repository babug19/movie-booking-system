package com.movie.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String language;
    private String genre;

}