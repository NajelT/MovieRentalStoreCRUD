package com.javamaster.spring_crud.service;


import com.javamaster.spring_crud.dto.MovieDto;
import com.javamaster.spring_crud.exception.ValidationException;

import java.util.List;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto) throws ValidationException;

    void deleteMovie(Integer movieId);

    MovieDto findByTitle(String movieTitle);

    List<MovieDto> findAll();
}
