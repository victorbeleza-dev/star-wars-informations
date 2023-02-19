package br.com.starwars.service.impl;

import br.com.starwars.client.ApiStarwarsClient;
import br.com.starwars.model.ListALlMovies;
import br.com.starwars.model.Movie;
import br.com.starwars.model.PeopleInfo;
import br.com.starwars.model.dto.MovieDTO;
import br.com.starwars.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private ApiStarwarsClient apiStarwarsClient;

    private static final String numberSkyWalker = "1";

    public List<MovieDTO> findAllMovies() {
        PeopleInfo peopleInfo = apiStarwarsClient.findPeople(numberSkyWalker);
        return getFilms(peopleInfo.getFilms());
    }

    private List<MovieDTO> getFilms(List<String> listMoviesURL) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        listMoviesURL.forEach(url ->{
            Movie movie = apiStarwarsClient.findFilm(url.substring(url.length() - 2, url.length() - 1));
            movieDTOList.add(MovieDTO.builder().episode_id(movie.getEpisode_id()).director(movie.getDirector()).release_date(formatDate(movie.getRelease_date())).title(movie.getTitle()).build());
        });

        return movieDTOList;
    }

    public List<MovieDTO> findMovieByIdAndTitle(String title, String episodioID) {
        ListALlMovies response = apiStarwarsClient.findAllFilms();

        List<Movie> listFilter = response.getResults().stream().filter(movie -> movie.getEpisode_id().equals(episodioID)).filter(z -> z.getTitle().equals(title)).toList();

        return convertListToDTO(listFilter);
    }

    private List<MovieDTO> convertListToDTO(List<Movie> listFilter) {
        List<MovieDTO> listDTO = new ArrayList<>();
        for (Movie m : listFilter) {
            listDTO.add(MovieDTO.builder().release_date(formatDate(m.getRelease_date())).director(m.getDirector()).title(m.getTitle()).episode_id(m.getEpisode_id()).build());
        }

        return listDTO;
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
