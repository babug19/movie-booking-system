package com.movie.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id @GeneratedValue
    private Long id;

    private String seatNumber;
    private boolean booked;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    private double price;


}
