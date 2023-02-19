package br.com.starwars.model;

import br.com.starwars.model.dto.MovieDTO;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovieMapper {

    private final ModelMapper modelMapper;

    public MovieMapper() {
        this.modelMapper = new ModelMapper();
    }

    public MovieDTO maptoDTO(Movie movie){
        MovieDTO response = modelMapper.map(movie, MovieDTO.class);
        response.setRelease_date(formatDate(response.getRelease_date()));
        return response;
    }

    private String formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date);
        return localDate.format(formatter);
    }
}
