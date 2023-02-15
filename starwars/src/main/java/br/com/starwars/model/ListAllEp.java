package br.com.starwars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListAllEp {

    private Integer count ;
    private Integer next;
    private Integer previous;
    private List<Film> results;
}
