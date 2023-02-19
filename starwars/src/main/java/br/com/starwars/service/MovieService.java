package br.com.starwars.service;

import br.com.starwars.model.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface MovieService {

    List<MovieDTO> findAllMovies();

    List<MovieDTO> findMovieByIdAndTitle(String title, String episodioID);
}
