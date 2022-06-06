package com.czarnowski.movieinfoservice.resources;

import com.czarnowski.movieinfoservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
