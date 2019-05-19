package uk.gov.companieshouse.moviefinder.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Movies {

    @JsonProperty("movies")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
