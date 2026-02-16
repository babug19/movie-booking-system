package com.movie.booking.service;

import com.movie.booking.dto.ShowRequest;
import com.movie.booking.entity.Movie;
import com.movie.booking.entity.Seat;
import com.movie.booking.entity.Show;
import com.movie.booking.entity.Theatre;
import com.movie.booking.exceptions.CustomException;
import com.movie.booking.repository.MovieRepository;
import com.movie.booking.repository.SeatRepository;
import com.movie.booking.repository.ShowRepository;
import com.movie.booking.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final TheatreRepository theatreRepository;
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;
    public ShowService(ShowRepository showRepository, TheatreRepository theatreRepository, MovieRepository movieRepository, SeatRepository seatRepository){
        this.showRepository = showRepository;
        this.theatreRepository = theatreRepository;
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
    }

    public String createShow(ShowRequest request) {

        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new CustomException("Movie not found"));

        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() -> new CustomException("Theatre not found"));

        Show show = new Show();
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setShowDate(request.getShowDate());
        show.setShowTime(request.getShowTime());

        Show savedShow =  showRepository.save(show);
        createSeatsForShow(savedShow);
        return "Success";
    }

    private void createSeatsForShow(Show show) {

        List<Seat> seats = new ArrayList<>();

        for (char row = 'A'; row <= 'E'; row++) {
            for (int num = 1; num <= 10; num++) {

                Seat seat = new Seat();
                seat.setSeatNumber(row + String.valueOf(num));
                seat.setBooked(false);
                seat.setPrice(200);
                seat.setShow(show);

                seats.add(seat);
            }
        }

        seatRepository.saveAll(seats);
    }
}
