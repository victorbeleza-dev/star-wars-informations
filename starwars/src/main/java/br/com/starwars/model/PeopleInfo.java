package br.com.starwars.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PeopleInfo {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_yea;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;
}
