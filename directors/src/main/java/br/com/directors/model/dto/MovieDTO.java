package br.com.directors.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String title;
    private String episode_id;
    private String director;
    private String release_date;

}
