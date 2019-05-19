package uk.gov.companieshouse.moviefinder.web.controller.overview;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class OverviewControllerTest {

    private MockMvc mockMvc;

    private OverviewController overviewController = new OverviewController();

    private static final String PATH = "/";
    private static final String OVERVIEW_MODEL_ATTR = "overview";
    private static final String OVERVIEW_VIEW = "overview";

    private static final String ACTION_VIEW_ALL_MOVIES = "viewAllMovies";
    private static final String PATH_VIEW_ALL_MOVIES = "/movies/all";

    private static final String ACTION_VIEW_MOVIE_WITH_MOST_LIKES = "viewMovieWithMostLikes";
    private static final String PATH_VIEW_MOVIE_WITH_MOST_LIKES = "/movies/most-likes";

    private static final String ACTION_VIEW_USER_WITH_MOST_COMMENTS = "viewUserWithMostComments";
    private static final String PATH_VIEW_USER_WITH_MOST_COMMENTS = "/users/most-comments";

    private static final String ACTION_OTHER = "other";

    private static final String ERROR_VIEW = "error";

    @BeforeEach
    private void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(overviewController).build();
    }

    @Test
    @DisplayName("Get overview")
    void getOverview() throws Exception {

        mockMvc.perform(get(PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(OVERVIEW_VIEW))
                .andExpect(model().attributeExists(OVERVIEW_MODEL_ATTR));
    }

    @Test
    @DisplayName("Post overview - view all movies")
    void postOverviewViewAllMovies() throws Exception {

        mockMvc.perform(createPostRequestWithAction(ACTION_VIEW_ALL_MOVIES))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(
                        UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_ALL_MOVIES));
    }

    @Test
    @DisplayName("Post overview - view the movie with the most likes")
    void postOverviewViewMovieWithMostLikes() throws Exception {

        mockMvc.perform(createPostRequestWithAction(ACTION_VIEW_MOVIE_WITH_MOST_LIKES))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(
                        UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_MOVIE_WITH_MOST_LIKES));
    }

    @Test
    @DisplayName("Post overview - view the user with the most comments")
    void postOverviewViewUserWithMostComments() throws Exception {

        mockMvc.perform(createPostRequestWithAction(ACTION_VIEW_USER_WITH_MOST_COMMENTS))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(
                        UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_USER_WITH_MOST_COMMENTS));
    }

    @Test
    @DisplayName("Post overview - another action")
    void postOverviewAnotherAction() throws Exception {

        mockMvc.perform(createPostRequestWithAction(ACTION_OTHER))
                .andExpect(status().isOk())
                .andExpect(view().name(ERROR_VIEW));
    }

    private MockHttpServletRequestBuilder createPostRequestWithAction(String action) {

        return post(PATH).param("action", action);
    }

}
