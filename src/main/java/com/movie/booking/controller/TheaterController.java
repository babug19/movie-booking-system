package com.movie.booking.controller;

import com.movie.booking.dto.CreateTheatreRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.service.MovieService;
import com.movie.booking.service.TheatreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatres")
public class TheaterController {

    private final TheatreService theatreService;

    public TheaterController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    @PostMapping
    public String saveTheatre(@RequestBody CreateTheatreRequest theatreRequest){
        theatreService.createTheatre(theatreRequest);
        return "success";
    }
}
