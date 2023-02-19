package br.com.directors.service.impl;

import br.com.directors.client.ApiMoviesClient;
import br.com.directors.model.MovieEntity;
import br.com.directors.model.MovieMapper;
import br.com.directors.model.dto.MovieDTO;
import br.com.directors.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureMockMvc
public class DirectorsServiceImplTest {

    @InjectMocks
    private DirectorsServiceImpl directorsService;

    @MockBean
    private ApiMoviesClient apiMoviesClient;

    @MockBean
    private MovieRepository movieRepository;

    private final MovieMapper movieMapper = new MovieMapper();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        standaloneSetup(this.directorsService);
    }

    @Test
    void returnSuccess_whenGetAndInsertNewMovie() throws Exception {
        MovieDTO movie = MovieDTO.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();
        MovieEntity entity = movieMapper.mapToEntity(movie);

        Mockito.when(movieRepository.save(entity)).thenReturn(entity);
        Mockito.when(apiMoviesClient.findAllMovies()).thenReturn(new ArrayList<>());
        List<MovieDTO> movieDTO = directorsService.insertMovie(movie);
        assertThat(movie).isEqualTo(movieDTO.get(0));
    }
}
