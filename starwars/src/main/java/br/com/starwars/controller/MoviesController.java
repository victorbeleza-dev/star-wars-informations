package br.com.starwars.controller;

import br.com.starwars.model.dto.MovieDTO;
import br.com.starwars.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/informations")
public class MoviesController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findAllMovies() {
        return service.findAllMovies();
    }

    @GetMapping("/movie")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findMovieByIdAndTitle(@RequestParam String titleEp, @RequestParam String idEp) {
        return service.findMovieByIdAndTitle(titleEp, idEp);
    }
}
