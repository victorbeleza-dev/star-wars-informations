package br.com.starwars.client;

import br.com.starwars.model.ListAllMovies;
import br.com.starwars.model.Movie;
import br.com.starwars.model.PeopleInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${url.starwars}", name = "apiStarWars")
public interface ApiStarwarsClient {

    @GetMapping("/people/{id}")
    PeopleInfo findPeople(@PathVariable String id);

    @GetMapping("/films/{id}")
    Movie findMovie(@PathVariable String id);

    @GetMapping("/films")
    ListAllMovies findAllMovies();

}
