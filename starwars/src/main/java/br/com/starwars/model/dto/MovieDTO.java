package br.com.starwars.model.dto;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private String title;
    private String episode_id;
    private String director;
    private String release_date;

}
