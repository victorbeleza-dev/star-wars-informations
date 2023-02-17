package br.com.starwarsh2.controller;

import br.com.starwarsh2.client.ApiStarwarsClient;
import br.com.starwarsh2.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/director")
public class FilmsController {

    @Autowired
    private ApiStarwarsClient client;

    @GetMapping("/update")
    public String find() throws Exception{
        return  client.sendGetRequest();
    }

    @PostMapping("/film")
    public String creteFilm(@RequestBody Film newFilm){
        System.out.println(newFilm);
              return newFilm.getTitle();
    }

}
