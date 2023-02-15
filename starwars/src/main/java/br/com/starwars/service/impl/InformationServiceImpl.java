package br.com.starwars.service.impl;

import br.com.starwars.client.ApiStarwarsClient;
import br.com.starwars.model.Film;
import br.com.starwars.model.ListAllEp;
import br.com.starwars.model.PeopleInfo;
import br.com.starwars.model.dto.FilmDTO;
import br.com.starwars.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private ApiStarwarsClient apiStarwarsClient;

    public List<FilmDTO> findFilms() {
        PeopleInfo peopleInfo = apiStarwarsClient.findPeople();
        return getFilms(peopleInfo.getFilms());
    }

    private List<FilmDTO> getFilms(List<String> listFilmes){
        List<FilmDTO> filmList = new ArrayList<>();
        for(String urlFilm: listFilmes){
            Film film = apiStarwarsClient.findFilm(urlFilm.substring(urlFilm.length()-2,urlFilm.length()-1));
            filmList.add(FilmDTO.builder().episode_id(film.getEpisode_id()).director(film.getDirector())
                    .release_date(film.getRelease_date()).title(film.getTitle()).build());
        }

        return filmList;
    }

    public List<FilmDTO> findFilmByIdAndTitle(String title, String episodioID){
        ListAllEp response = apiStarwarsClient.findAllFilms();

        List<Film> listFilter = response.getResults()
                .stream()
                .filter(movie -> movie.getEpisode_id().equals(episodioID))
                .filter(z -> z.getTitle().equals(title))
                .toList();

        return convertListToDTO(listFilter);
    }

    private List<FilmDTO> convertListToDTO(List<Film> listFilter){
        List<FilmDTO> listDTO = new ArrayList<>();
        for(Film m: listFilter){
            listDTO.add(FilmDTO.builder().release_date(m.getRelease_date())
                    .director(m.getDirector()).title(m.getTitle()).episode_id(m.getEpisode_id()).build());
        }

        return listDTO;
    }
}
