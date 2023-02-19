package br.com.directors.service;

import br.com.directors.model.dto.MovieDTO;

import java.util.List;

public interface DirectorsService{

    List<MovieDTO> insertMovie(MovieDTO filmDTO);
}
