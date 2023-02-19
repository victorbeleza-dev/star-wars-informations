package br.com.starwars.service.impl;

import br.com.starwars.client.ApiStarwarsClient;
import br.com.starwars.model.ListAllMovies;
import br.com.starwars.model.Movie;
import br.com.starwars.model.MovieMapper;
import br.com.starwars.model.PeopleInfo;
import br.com.starwars.model.dto.MovieDTO;
import br.com.starwars.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private ApiStarwarsClient apiStarwarsClient;

    private static final String IDLUKESKYWALKER = "1";
    private final MovieMapper movieMapper = new MovieMapper();

    public List<MovieDTO> findAllMovies() {
        PeopleInfo peopleInfo = apiStarwarsClient.findPeople(IDLUKESKYWALKER);

        List<MovieDTO> movieDTOList = new ArrayList<>();

        peopleInfo.getFilms().forEach(url -> {
            Movie movie = apiStarwarsClient.findFilm(url.substring(url.length() - 2, url.length() - 1));
            movieDTOList.add(movieMapper.maptoDTO(movie));
        });

        return movieDTOList;
    }

    public List<MovieDTO> findMovieByIdAndTitle(String title, String episodioID) {
        ListAllMovies response = apiStarwarsClient.findAllFilms();

        List<Movie> listFilter = response.getResults().stream().filter(movie -> movie.getEpisode_id().equals(episodioID)).filter(mv -> mv.getTitle().equals(title)).toList();
        List<MovieDTO> listDTO = new ArrayList<>();

        listFilter.forEach(movie -> {
            listDTO.add(movieMapper.maptoDTO(movie));
        });

        return listDTO;
    }
}
