package com.czarnowski.moviecatalogservice.resources;

import com.czarnowski.moviecatalogservice.models.CatalogItem;
import com.czarnowski.moviecatalogservice.models.Movie;
import com.czarnowski.moviecatalogservice.models.Rating;
import com.czarnowski.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private final RestTemplate restTemplate;
//    private final WebClient.Builder webClientBuilder;

    @Autowired
    public MovieCatalogResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratingsdataservice/ratingsdata/users/" + userId,
                UserRating.class);

        return ratings.getUserRating().stream()
                .map(rating -> {
                    // get movie object for synchronous RestTemplate
                    // For each movie ID, call movie info service and get details
                    Movie movie = restTemplate.getForObject("http://movieinfoservice/movies/" + rating.getMovieId(), Movie.class);

                    // Put them all together
                    return new CatalogItem(movie.getName(), "Desc", rating.getRating());
                })
                .collect(Collectors.toList());

    }
}


// get movie object for asynchronous WebClient
// Reactive alternative to the RestTemplate
                    /*
                    Movie movie = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8082/movies/" + rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class) //Mono object can become an object that we need eventually
                            .block(); //block waits for Movie object - again synchronous
                     */