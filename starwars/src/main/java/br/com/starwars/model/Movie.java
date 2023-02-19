package br.com.starwars.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Movie {

    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private LocalDate release_date;

    private List<String> characters;

    private List<String> planets;

    private List<String> starships;

    private List<String> vehicles;

    private List<String> species;

    private String created;

    private String edited;

    private String url;
}
