package uk.gov.companieshouse.moviefinder.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Movie {

    @JsonProperty("movie_id")
    private int movieId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("available_in_3d")
    private boolean availableIn3D;

    @JsonProperty("age_rating")
    private String ageRating;

    @JsonProperty("likes")
    private int likes;

    @JsonProperty("comments")
    private List<Comment> comments;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isAvailableIn3D() {
        return availableIn3D;
    }

    public void setAvailableIn3D(boolean availableIn3D) {
        this.availableIn3D = availableIn3D;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
