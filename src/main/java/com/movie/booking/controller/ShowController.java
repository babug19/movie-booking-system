package com.movie.booking.controller;

import com.movie.booking.dto.ShowRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.entity.Show;
import com.movie.booking.service.MovieService;
import com.movie.booking.service.ShowService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    private final ShowService showService;
    public ShowController(ShowService showService){
        this.showService = showService;
    }

    @PostMapping("/shows")
    public String createShow(@RequestBody ShowRequest request) {
        return showService.createShow(request);
    }
}
