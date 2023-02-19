package br.com.starwars.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MovieDTO {

    private String title;
    private String episode_id;
    private String director;
    private String release_date;

}
