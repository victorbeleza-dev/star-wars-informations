package br.com.starwars.service.impl;

import br.com.starwars.client.ApiStarwarsClient;
import br.com.starwars.model.Film;
import br.com.starwars.model.ListAllEp;
import br.com.starwars.model.PeopleInfo;
import br.com.starwars.model.dto.FilmDTO;
import br.com.starwars.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private ApiStarwarsClient apiStarwarsClient;

    public List<FilmDTO> findFilms() throws ParseException {
        PeopleInfo peopleInfo = apiStarwarsClient.findPeople();
        return getFilms(peopleInfo.getFilms());
    }

    private List<FilmDTO> getFilms(List<String> listFilmes) throws ParseException {
        List<FilmDTO> filmList = new ArrayList<>();
        for(String urlFilm: listFilmes){
            Film film = apiStarwarsClient.findFilm(urlFilm.substring(urlFilm.length()-2,urlFilm.length()-1));
            filmList.add(FilmDTO.builder().episode_id(film.getEpisode_id()).director(film.getDirector())
                    .release_date(formatDate(film.getRelease_date())).title(film.getTitle()).build());
        }

        return filmList;
    }

    public List<FilmDTO> findFilmByIdAndTitle(String title, String episodioID) throws ParseException {
        ListAllEp response = apiStarwarsClient.findAllFilms();

        List<Film> listFilter = response.getResults()
                .stream()
                .filter(movie -> movie.getEpisode_id().equals(episodioID))
                .filter(z -> z.getTitle().equals(title))
                .toList();

        return convertListToDTO(listFilter);
    }

    private List<FilmDTO> convertListToDTO(List<Film> listFilter) throws ParseException {
        List<FilmDTO> listDTO = new ArrayList<>();
        for(Film m: listFilter){
            listDTO.add(FilmDTO.builder().release_date(formatDate(m.getRelease_date()))
                    .director(m.getDirector()).title(m.getTitle()).episode_id(m.getEpisode_id()).build());
        }

        return listDTO;
    }

    private String formatDate(String date) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date converted = formato.parse(date);

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(converted);
    }
}
