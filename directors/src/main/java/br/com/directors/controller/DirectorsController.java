package br.com.directors.controller;

import br.com.directors.model.dto.MovieDTO;
import br.com.directors.service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorsController {

    @Autowired
    private DirectorsService directorsService;

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MovieDTO> insertMovie(@RequestBody MovieDTO movie){
        return directorsService.insertMovie(movie);
    }

}
