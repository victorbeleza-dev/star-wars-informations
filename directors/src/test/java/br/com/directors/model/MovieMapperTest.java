package br.com.directors.model;

import br.com.directors.model.dto.MovieDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class MovieMapperTest {

    @MockBean
    private MovieMapper movieMapper;

    @Test
    void convertToEntity(){
        MovieDTO movie = MovieDTO.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();
        MovieEntity movieEntity = MovieEntity.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();

        Mockito.when(movieMapper.mapToEntity(movie)).thenReturn(movieEntity);
        MovieEntity movieConverted = movieMapper.mapToEntity(movie);

        Assertions.assertEquals(movieConverted.getTitle(), movie.getTitle());
        Assertions.assertEquals(movieConverted.getDirector(), movie.getDirector());
        Assertions.assertEquals(movieConverted.getEpisode_id(), movie.getEpisode_id());
    }

    @Test
    void convertToDTO(){
        MovieDTO movie = MovieDTO.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();
        MovieEntity movieEntity = MovieEntity.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();

        Mockito.when(movieMapper.mapToDTO(movieEntity)).thenReturn(movie);
        MovieDTO movieConverted = movieMapper.mapToDTO(movieEntity);

        Assertions.assertEquals(movieConverted.getTitle(), movie.getTitle());
        Assertions.assertEquals(movieConverted.getDirector(), movie.getDirector());
        Assertions.assertEquals(movieConverted.getEpisode_id(), movie.getEpisode_id());
    }
}
