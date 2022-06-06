package com.czarnowski.movieinfoservice.resources;

import com.czarnowski.movieinfoservice.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initMovieDatabase(MovieRepository movieRepository) {

        return args -> {
            movieRepository.save(new Movie("Spiderman"));
            movieRepository.save(new Movie("Scarface"));
            movieRepository.save(new Movie("Big Short"));
            movieRepository.save(new Movie("Transformers"));

            movieRepository.findAll().forEach(movie -> log.info("Preloaded " + movie));
        };
    }
}
