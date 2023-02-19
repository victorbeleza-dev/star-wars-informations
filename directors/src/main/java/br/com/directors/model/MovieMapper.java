package br.com.directors.model;

import br.com.directors.model.dto.MovieDTO;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovieMapper {

    private final ModelMapper modelMapper;

    public MovieMapper() {
        this.modelMapper = new ModelMapper();
    }

    public MovieEntity mapToEntity(MovieDTO movie) {
        return modelMapper.map(movie, MovieEntity.class);
    }

    public MovieDTO mapToDTO(MovieEntity movie){
        return modelMapper.map(movie, MovieDTO.class);
    }

}
