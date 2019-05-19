package uk.gov.companieshouse.moviefinder.web.controller.movie;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.companieshouse.moviefinder.web.model.Movie;
import uk.gov.companieshouse.moviefinder.web.service.MovieService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieWithMostLikesControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieWithMostLikesController movieWithMostLikesController;

    @Mock
    private Movie movie;

    private static final String PATH = "/movies/most-likes";
    private static final String MOVIE_MODEL_ATTR = "movie";
    private static final String MOVIE_WITH_MOST_LIKES_VIEW = "movieWithMostLikes";

    @Test
    @DisplayName("Get the movie with the most likes")
    void getMovieWithMostLikes() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(movieWithMostLikesController).build();

        when(movieService.getMovieWithMostLikes()).thenReturn(movie);

        mockMvc.perform(get(PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(MOVIE_WITH_MOST_LIKES_VIEW))
                .andExpect(model().attributeExists(MOVIE_MODEL_ATTR));
    }

}
