package br.com.starwarsh2.service.impl;

import br.com.starwarsh2.client.ApiMoviesClient;
import br.com.starwarsh2.model.MovieEntity;
import br.com.starwarsh2.model.MovieMapper;
import br.com.starwarsh2.model.dto.MovieDTO;
import br.com.starwarsh2.repository.MovieRepository;
import br.com.starwarsh2.service.DirectorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorsServiceImpl implements DirectorsService {
    private static final Logger log = LoggerFactory.getLogger(DirectorsServiceImpl.class);

    @Autowired
    private ApiMoviesClient apiMoviesClient;

    @Autowired
    private MovieRepository movieRepository;

    private final MovieMapper movieMapper = new MovieMapper();

    @Override
    public void insertMovie(MovieDTO movieDTO) {
        List<MovieEntity> listMV = movieRepository.findAll();

        if(listMV.isEmpty()){
            List<MovieDTO> listMovies = apiMoviesClient.findAllFilms();
            listMovies.add(movieDTO);

            log.info("Lista de filmes atualizada:");
            listMovies.forEach(movie ->{
                log.info("title: " + movie.getTitle());
                movieRepository.save(movieMapper.mapToEntity(movie));
            });
        }else {
            listMV.add(movieMapper.mapToEntity(movieDTO));
            log.info("!Lista de filmes atualizada:");
            listMV.forEach(movie -> {
                log.info("title: " + movie.getTitle());
                movieRepository.save(movie);
            });
        }
    }
}
