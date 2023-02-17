package br.com.starwarsh2.repository;

import br.com.starwarsh2.model.FilmEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<FilmEntity,Long> {
}

