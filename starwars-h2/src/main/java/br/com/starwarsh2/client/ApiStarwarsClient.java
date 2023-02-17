package br.com.starwarsh2.client;


import br.com.starwarsh2.model.Film;
import br.com.starwarsh2.model.FilmEntity;
import br.com.starwarsh2.model.FilmMapper;
import br.com.starwarsh2.repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ApiStarwarsClient {


    @Autowired
    private FilmRepository filmRepository;

    public String sendGetRequest() throws IOException {
        FilmMapper filmMapper = new FilmMapper();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/informations/films", String.class);
        String body = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        List<Film> films = Arrays.asList(mapper.readValue(body, Film[].class));
        Stream<Film> filmStream = films.stream();
        filmStream.forEach(film -> {
            System.out.println(film.getTitle());
            FilmEntity entity = filmMapper.mapToEntity(film);
            System.out.println(entity);
            filmRepository.save(entity);
        });
        return body;
    }

}
