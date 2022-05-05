package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByTitle(String movieTitle);

}
