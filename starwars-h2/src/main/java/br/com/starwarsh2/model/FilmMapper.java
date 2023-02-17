package br.com.starwarsh2.model;

import org.modelmapper.ModelMapper;

public class FilmMapper {

    private ModelMapper modelMapper;

    public FilmMapper() {
        this.modelMapper = new ModelMapper();
    }

    public FilmEntity mapToEntity(Film film) {
        System.out.println(film);
        return modelMapper.map(film, FilmEntity.class);
    }

}
