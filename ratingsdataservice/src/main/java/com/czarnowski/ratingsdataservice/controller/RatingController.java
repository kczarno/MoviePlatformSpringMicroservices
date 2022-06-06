package com.czarnowski.ratingsdataservice.controller;

import com.czarnowski.ratingsdataservice.models.Rating;
import com.czarnowski.ratingsdataservice.resources.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") Long movieId) {
        return ratingRepository.findById(movieId)
                .orElseThrow(() -> new RatingNotFoundException(movieId));
    }

    @GetMapping("users/{userId}")
    public List<Rating> getUserRating(@PathVariable("userId") String userId) {
        return ratingRepository.findAllByUserId(userId);
    }
}
