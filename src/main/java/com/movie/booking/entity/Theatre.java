package com.movie.booking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Theatre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Show> showTimes = new HashSet<>();
}
