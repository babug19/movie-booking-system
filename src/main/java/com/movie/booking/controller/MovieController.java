package com.movie.booking.controller;

import com.movie.booking.dto.MovieRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/health")
    public String health() {
        return "Movie booking service is up";
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public String saveMovies(@RequestBody MovieRequest movieRequest){
        movieService.saveMovies(movieRequest);
        return "success";
    }
}
