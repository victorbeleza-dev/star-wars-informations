package br.com.directors.client;

import br.com.directors.model.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${url.api.movies}", name = "apiMoviesClient")
public interface ApiMoviesClient {

    @GetMapping("/informations/movies")
    List<MovieDTO> findAllMovies();
}
