package uk.gov.companieshouse.moviefinder.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDate;
import uk.gov.companieshouse.moviefinder.web.util.LocalDateFromEpochDeserializer;

public class Comment {

    @JsonProperty("user")
    private String user;

    @JsonProperty("message")
    private String message;

    @JsonDeserialize(using = LocalDateFromEpochDeserializer.class)
    @JsonProperty("dateCreated")
    private LocalDate dateCreated;

    @JsonProperty("like")
    private int like;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
