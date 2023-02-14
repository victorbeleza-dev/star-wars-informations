package br.com.starwars.controller;

import br.com.starwars.client.ApiStarwarsClient;
import br.com.starwars.model.PeopleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {

    @Autowired
    private ApiStarwarsClient apiStarwarsClient;

    @GetMapping
    public PeopleInfo teste(){
        return apiStarwarsClient.teste();
    }
}
