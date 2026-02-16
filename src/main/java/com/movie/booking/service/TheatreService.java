package com.movie.booking.service;

import com.movie.booking.dto.CreateTheatreRequest;
import com.movie.booking.entity.Theatre;
import com.movie.booking.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TheatreService {


        private final TheatreRepository theatreRepository;

        public Theatre createTheatre(CreateTheatreRequest request) {

            Theatre theatre = new Theatre();
            theatre.setName(request.getName());
            theatre.setCity(request.getCity());

            return theatreRepository.save(theatre);
        }

        public List<Theatre> getAllTheatres() {
            return theatreRepository.findAll();
        }
}
