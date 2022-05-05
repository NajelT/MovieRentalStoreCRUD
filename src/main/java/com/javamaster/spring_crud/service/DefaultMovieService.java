package com.javamaster.spring_crud.service;


import com.javamaster.spring_crud.dto.MovieDto;
import com.javamaster.spring_crud.entity.Movie;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@Service
@AllArgsConstructor
public class DefaultMovieService implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    @Override
    public MovieDto saveMovie(MovieDto movieDto) throws ValidationException {
        validateMovieDto(movieDto);
        Movie savedMovie = movieConverter.fromMovieDtoToMovie(movieDto);
        return movieConverter
                .fromMovieToMovieDto(movieRepository.save(savedMovie));
    }

    private void validateMovieDto(MovieDto movieDto) throws ValidationException {
        if(isNull(movieDto)){
            throw new ValidationException("object movie is null");
        }
        if(isNull(movieDto.getTitle()) || movieDto.getTitle().isEmpty()){
            throw new ValidationException("Title is empty");
        }
    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public MovieDto findByTitle(String movieTitle) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        if(movie != null){
            return movieConverter.fromMovieToMovieDto(movie);
        }
        return null;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(it -> movieConverter.fromMovieToMovieDto(it))
                .collect(Collectors.toList());
    }
}
