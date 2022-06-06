package com.czarnowski.ratingsdataservice.resources;

import com.czarnowski.ratingsdataservice.models.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initUserRatingDatabase(RatingRepository ratingRepository) {

        return args -> {
            ratingRepository.save(new Rating("Karol", "Transformers", 3));
            ratingRepository.save(new Rating("Karol", "Matrix", 5));
            ratingRepository.save(new Rating("Karol", "Trainspotting", 4));

            ratingRepository.save(new Rating("Tomasz", "Matrix", 3));

            ratingRepository.save(new Rating("Robert", "Trainspotting", 5));

            ratingRepository.findAll().forEach(rating -> log.info("Preloaded " + rating));
        };
    }
}
