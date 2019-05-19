package uk.gov.companieshouse.moviefinder.web.controller.movie;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
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
public class AllMoviesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private AllMoviesController allMoviesController;

    @Mock
    private List<Movie> movieList;

    private static final String PATH = "/movies/all";
    private static final String MOVIE_LIST_MODEL_ATTR = "movieList";
    private static final String ALL_MOVIES_VIEW = "fullMovieList";

    @Test
    @DisplayName("Get all movies")
    void getAllMovies() throws Exception {

        this.mockMvc = MockMvcBuilders.standaloneSetup(allMoviesController).build();

        when(movieService.getFullMovieList()).thenReturn(movieList);

        mockMvc.perform(get(PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(ALL_MOVIES_VIEW))
                .andExpect(model().attributeExists(MOVIE_LIST_MODEL_ATTR));
    }

}
