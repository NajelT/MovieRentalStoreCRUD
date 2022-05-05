package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.MovieDto;
import com.javamaster.spring_crud.entity.Movie;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultMovieServiceTest {
    private MovieService movieService;
    private MovieRepository movieRepository;
    private MovieConverter movieConverter;
    private Movie movie;

    @BeforeEach
    void setUp(){
        movieRepository = mock(MovieRepository.class);
        movieConverter = new MovieConverter();
        movie = new Movie();
        movie.setId(1);
        movie.setTitle("The Matrix");
        movie.setCategory("action");
        movie.setMainCharacter("Neo");
        movie.setDescription("red or blue?");
        movie.setReleaseDate("12.22.1999");
        movie.setPrice(BigDecimal.valueOf(4.99));

//        movie = Movie.builder()
//                .id(1)
//                .title("The Matrix")
//                .category("action")
//                .mainCharacter("Neo")
//                .description("uaaa")
//                .releaseDate(LocalDate.of(1999, 8, 12))
//                .price(BigDecimal.TEN)
//                .build();
        when(movieRepository.save(any())).thenReturn(movie);
        movieService = new DefaultMovieService(movieRepository, movieConverter);
    }

    @Test
    void saveMovieReturnMovieDto() throws ValidationException {
        MovieDto movieDto = MovieDto.builder()
                .title("The Matrix")
                .build();
        MovieDto savedMovieDto = movieService.saveMovie(movieDto);
        assertThat(savedMovieDto).isNotNull();
        assertThat(savedMovieDto.getTitle()).isEqualTo("The Matrix");
    }

    @Test
    void saveMovieWithNullTitleThrowsValidationException(){
        MovieDto movieDto = MovieDto.builder().build();
        assertThrows(ValidationException.class,
                () -> movieService.saveMovie(movieDto),
                "Title is empty");
    }



}