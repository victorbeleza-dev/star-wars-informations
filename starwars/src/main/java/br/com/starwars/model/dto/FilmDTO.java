package br.com.starwars.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmDTO {

    private String title;
    private String episode_id;
    private String release_date;
}
