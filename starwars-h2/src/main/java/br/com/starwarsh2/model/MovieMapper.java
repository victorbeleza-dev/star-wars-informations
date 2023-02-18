package br.com.starwarsh2.model;

import br.com.starwarsh2.model.dto.MovieDTO;
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
