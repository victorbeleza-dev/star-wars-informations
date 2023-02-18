package br.com.starwarsh2.controller;

import br.com.starwarsh2.model.dto.MovieDTO;
import br.com.starwarsh2.service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/director")
public class FilmsController {

    @Autowired
    private DirectorsService directorsService;

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMovie(@RequestBody MovieDTO movie){
        directorsService.insertMovie(movie);
    }

}
