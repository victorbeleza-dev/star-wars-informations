package br.com.directors.controller;

import br.com.directors.client.ApiMoviesClient;
import br.com.directors.model.dto.MovieDTO;
import br.com.directors.repository.MovieRepository;
import br.com.directors.service.impl.DirectorsServiceImpl;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DirectorsControllerTest {

    @MockBean
    private DirectorsServiceImpl directorsService;

    @MockBean
    private ApiMoviesClient apiMoviesClient;

    @MockBean
    private MovieRepository movieRepository;

    @MockBean
    private DirectorsController controller;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(controller);
    }

    @Test
    void mustuReturnSuccess_whenInsertNewMovie() throws Exception {
        MovieDTO movie = MovieDTO.builder().title("Novo Filme SW").director("VICTORBELEZA").episode_id("2").release_date("30/12/1998").build();

        given()
                .contentType(ContentType.JSON)
                .body(movie)
                .when()
                .post("/director/movie")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }
}
