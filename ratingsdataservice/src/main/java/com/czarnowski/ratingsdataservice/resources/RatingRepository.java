package com.czarnowski.ratingsdataservice.resources;

import com.czarnowski.ratingsdataservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByUserId(String userId);
}
