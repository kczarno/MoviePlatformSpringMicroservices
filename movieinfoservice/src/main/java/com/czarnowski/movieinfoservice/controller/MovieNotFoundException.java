package com.czarnowski.movieinfoservice.controller;

public class MovieNotFoundException extends RuntimeException {

    MovieNotFoundException(String name) {
        super("Could not find a movie with name: " + name);
    }
}
