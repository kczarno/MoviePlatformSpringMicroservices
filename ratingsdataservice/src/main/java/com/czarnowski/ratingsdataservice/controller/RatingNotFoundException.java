package com.czarnowski.ratingsdataservice.controller;

public class RatingNotFoundException extends RuntimeException {

    RatingNotFoundException(Long id) {
        super("Could not find rating with id: " + id);
    }

}
