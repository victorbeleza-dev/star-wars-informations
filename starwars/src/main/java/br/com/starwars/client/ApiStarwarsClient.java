package br.com.starwars.client;

import br.com.starwars.model.PeopleInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://swapi.dev/api/", name = "apiStarWars")
public interface ApiStarwarsClient {

    @GetMapping("/people/1")
    PeopleInfo teste ();
}
