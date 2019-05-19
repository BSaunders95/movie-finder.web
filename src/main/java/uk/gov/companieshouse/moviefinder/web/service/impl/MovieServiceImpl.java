package uk.gov.companieshouse.moviefinder.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.companieshouse.moviefinder.web.model.Movie;
import uk.gov.companieshouse.moviefinder.web.model.Movies;
import uk.gov.companieshouse.moviefinder.web.request.RequestExecutor;
import uk.gov.companieshouse.moviefinder.web.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RequestExecutor requestExecutor;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> getFullMovieList() {

        return requestExecutor.executeGetRequest("/movies", Movies.class).getMovieList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovieWithMostLikes() {

        return requestExecutor.executeGetRequest("/movies/most-likes", Movie.class);
    }
}
