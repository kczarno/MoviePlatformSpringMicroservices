package com.czarnowski.movieinfoservice.controller;

public class MovieNotFoundException extends RuntimeException {

    MovieNotFoundException(Long id) {
        super("Could not find a movie with id: " + id);
    }
}
