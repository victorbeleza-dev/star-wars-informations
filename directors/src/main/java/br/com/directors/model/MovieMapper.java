package br.com.directors.model;

import br.com.directors.model.dto.MovieDTO;
import org.modelmapper.ModelMapper;

public class MovieMapper {

    private final ModelMapper modelMapper;

    public MovieMapper() {
        this.modelMapper = new ModelMapper();
    }

    public MovieEntity mapToEntity(MovieDTO movie) {
        return modelMapper.map(movie, MovieEntity.class);
    }

}
