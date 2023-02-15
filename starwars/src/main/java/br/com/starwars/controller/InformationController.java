package br.com.starwars.controller;

import br.com.starwars.model.Film;
import br.com.starwars.model.dto.FilmDTO;
import br.com.starwars.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/informations")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/films")
    public List<FilmDTO> find() throws URISyntaxException {
        return informationService.findFilms();
    }
}
