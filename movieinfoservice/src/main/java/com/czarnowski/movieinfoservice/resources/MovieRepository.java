package com.czarnowski.movieinfoservice.resources;

import com.czarnowski.movieinfoservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);

}
