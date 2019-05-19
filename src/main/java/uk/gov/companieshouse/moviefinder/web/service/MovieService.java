package uk.gov.companieshouse.moviefinder.web.service;

import java.util.List;
import uk.gov.companieshouse.moviefinder.web.model.Movie;

public interface MovieService {

    /**
     * Fetches a full list of movies
     *
     * @return a {@link List>} of {@link Movie}'s
     */
    List<Movie> getFullMovieList();

    /**
     * Fetches the movie with the most likes
     *
     * @return the {@link Movie} with the most likes
     */
    Movie getMovieWithMostLikes();
}
