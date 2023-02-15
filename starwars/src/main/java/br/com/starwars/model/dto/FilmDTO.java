package br.com.starwars.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class FilmDTO {

    private String title;
    private String episode_id;
    private String director;
    private String release_date;

}
