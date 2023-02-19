package br.com.directors.repository;

import br.com.directors.model.MovieEntity;
import br.com.directors.model.MovieMapper;
import br.com.directors.model.dto.MovieDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureMockMvc
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    protected TestEntityManager entityManager;

    private final MovieMapper movieMapper = new MovieMapper();
    @Test
    void findAllMovies(){
        MovieDTO movie = MovieDTO.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();
        MovieEntity movieEntity = entityManager.persist(movieMapper.mapToEntity(movie));

        Assertions.assertEquals(movieEntity.getTitle(), movie.getTitle());
        Assertions.assertEquals(movieEntity.getEpisode_id(), movie.getEpisode_id());
        Assertions.assertEquals(movieEntity.getDirector(), movie.getDirector());
        Assertions.assertEquals(movieEntity.getRelease_date(), movie.getRelease_date());
    }
}
