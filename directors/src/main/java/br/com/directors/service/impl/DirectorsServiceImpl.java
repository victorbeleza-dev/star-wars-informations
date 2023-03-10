package br.com.directors.service.impl;

import br.com.directors.client.ApiMoviesClient;
import br.com.directors.model.MovieEntity;
import br.com.directors.model.MovieMapper;
import br.com.directors.model.dto.MovieDTO;
import br.com.directors.repository.MovieRepository;
import br.com.directors.service.DirectorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MovieDTO> insertMovie(MovieDTO movieDTO) {
        List<MovieEntity> listMV = movieRepository.findAll();

        if(listMV.isEmpty()){
            List<MovieDTO> listMovies = apiMoviesClient.findAllMovies();
            listMovies.add(movieDTO);

            log.info("!Lista de filmes atualizada:");
            listMovies.forEach(movie ->{
                log.info("title: " + movie.getTitle());
                movieRepository.save(movieMapper.mapToEntity(movie));
            });
            return listMovies;
        }else {
            List<MovieDTO> listMoviesDTO = new ArrayList<>();

            listMV.add(movieMapper.mapToEntity(movieDTO));
            movieRepository.saveAll(listMV);

            log.info("!Lista de filmes atualizada:");
            listMV.forEach(movie -> {
                log.info("title: " + movie.getTitle());
                listMoviesDTO.add(movieMapper.mapToDTO(movie));
            });

            return listMoviesDTO;
        }
    }
}
