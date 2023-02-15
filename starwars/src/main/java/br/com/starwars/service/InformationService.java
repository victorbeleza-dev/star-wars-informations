package br.com.starwars.service;

import br.com.starwars.model.Film;
import br.com.starwars.model.dto.FilmDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface InformationService {

    List<FilmDTO> findFilms() throws ParseException;

    List<FilmDTO> findFilmByIdAndTitle(String title, String episodioID) throws ParseException;
}
