package com.movie.booking.service;

import com.movie.booking.dto.MovieRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.exceptions.CustomException;
import com.movie.booking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    private final MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository){

        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovies(MovieRequest movieRequest){
        Movie movie = new Movie();
        movie.setGenre(movieRequest.getGenre());
        movie.setName(movie.getName());
        movie.setLanguage(movieRequest.getLanguage());
        movieRepository.save(movie);
    }
}
