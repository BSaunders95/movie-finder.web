package uk.gov.companieshouse.moviefinder.web.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.companieshouse.moviefinder.web.model.Movie;
import uk.gov.companieshouse.moviefinder.web.model.Movies;
import uk.gov.companieshouse.moviefinder.web.request.RequestExecutor;
import uk.gov.companieshouse.moviefinder.web.service.MovieService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieServiceImplTest {

    @Mock
    private RequestExecutor requestExecutor;

    @InjectMocks
    private MovieService movieService = new MovieServiceImpl();

    @Mock
    private Movies movies;

    @Mock
    private List<Movie> movieList;

    @Mock
    private Movie movie;

    @Test
    @DisplayName("Get full movie list")
    void getFullMovieList() {

        when(requestExecutor.executeGetRequest("/movies", Movies.class))
                .thenReturn(movies);

        when(movies.getMovieList()).thenReturn(movieList);

        List<Movie> returnedMovieList = movieService.getFullMovieList();

        assertEquals(movieList, returnedMovieList);
    }

    @Test
    @DisplayName("Get the movie with the most likes")
    void getMovieWithMostLikes() {

        when(requestExecutor.executeGetRequest("/movies/most-likes", Movie.class))
                .thenReturn(movie);

        Movie returnedMovie = movieService.getMovieWithMostLikes();

        assertEquals(movie, returnedMovie);
    }
}
