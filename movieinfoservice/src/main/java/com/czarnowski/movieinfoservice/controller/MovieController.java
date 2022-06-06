package com.czarnowski.movieinfoservice.controller;

import com.czarnowski.movieinfoservice.models.Movie;
import com.czarnowski.movieinfoservice.resources.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/{name}")
    public Movie getMovieInfo(@PathVariable("name") String name) {

        return movieRepository.findMovieByName(name)
                .orElseThrow(() -> new MovieNotFoundException(name));

    }

    @GetMapping
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();

    }


}
