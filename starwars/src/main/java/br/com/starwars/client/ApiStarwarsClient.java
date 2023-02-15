package br.com.starwars.client;

import br.com.starwars.model.Film;
import br.com.starwars.model.PeopleInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(url = "https://swapi.dev/api/", name = "apiStarWars")
public interface ApiStarwarsClient {

    @GetMapping("/people/1")
    PeopleInfo findPeople();

    @GetMapping("/films/{id}")
    Film findFilm(@PathVariable String id);

}
