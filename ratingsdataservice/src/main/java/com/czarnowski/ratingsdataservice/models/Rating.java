package com.czarnowski.ratingsdataservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String movieName;

    private int rating;

    public Rating() {
    }

    public Rating(String userId, String movieName, int rating) {
        this.userId = userId;
        this.movieName = movieName;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating && Objects.equals(id, rating1.id) && Objects.equals(userId, rating1.userId) && Objects.equals(movieName, rating1.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, movieName, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
