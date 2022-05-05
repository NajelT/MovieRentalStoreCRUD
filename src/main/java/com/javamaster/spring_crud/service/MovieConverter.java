package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.MovieDto;
import com.javamaster.spring_crud.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    public Movie fromMovieDtoToMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setCategory(movieDto.getCategory());
        movie.setMainCharacter(movieDto.getMainCharacter());
        movie.setDescription(movieDto.getDescription());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setPrice(movieDto.getPrice());
        return movie;

//        return Movie.builder()
//                .id(movieDto.getId())
//                .title(movieDto.getTitle())
//                .category(movieDto.getCategory())
//                .mainCharacter(movieDto.getMainCharacter())
//                .description(movieDto.getDescription())
//                .releaseDate(movieDto.getReleaseDate())
//                .price(movieDto.getPrice())
//                .build();
    }

    public MovieDto fromMovieToMovieDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .category(movie.getCategory())
                .mainCharacter(movie.getMainCharacter())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .price(movie.getPrice())
                .build();
    }
}
