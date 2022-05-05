package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.MovieDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
@AllArgsConstructor
@Log
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/save")
    public MovieDto saveMovie(@RequestBody MovieDto movieDto) throws ValidationException {
        log.info("Handling save movie: " + movieDto);
        return movieService.saveMovie(movieDto);
    }

    @GetMapping("/findAll")
    public List<MovieDto> findAllMovies(){
        log.info("Handling find all movies request");
        return movieService.findAll();
    }

    @GetMapping("/findByTitle")
    public MovieDto findByTitle(@RequestParam String title){
        log.info("Handling find by title request: " + title);
        return movieService.findByTitle(title);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id){
        log.info("Handling delete movie request: " + id);
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

}
