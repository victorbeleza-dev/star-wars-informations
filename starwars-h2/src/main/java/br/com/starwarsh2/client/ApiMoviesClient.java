package br.com.starwarsh2.client;

import br.com.starwarsh2.model.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${url.feign.api.movies}", name = "apiMoviesClient")
public interface ApiMoviesClient {

    @GetMapping("/informations/movies")
    List<MovieDTO> findAllFilms();
}
