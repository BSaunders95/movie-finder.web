package uk.gov.companieshouse.moviefinder.web.controller.user;

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
import uk.gov.companieshouse.moviefinder.web.model.User;
import uk.gov.companieshouse.moviefinder.web.service.UserService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserWithMostCommentsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserWithMostCommentsController userWithMostCommentsController;

    @Mock
    private User user;

    private static final String PATH = "/users/most-comments";
    private static final String USER_MODEL_ATTR = "user";
    private static final String USER_WITH_MOST_COMMENTS_VIEW = "userWithMostComments";

    @Test
    @DisplayName("Get the user with the most comments")
    void getUserWithMostComments() throws Exception {

        this.mockMvc = MockMvcBuilders.standaloneSetup(userWithMostCommentsController).build();

        when(userService.getUserWithMostComments()).thenReturn(user);

        mockMvc.perform(get(PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(USER_WITH_MOST_COMMENTS_VIEW))
                .andExpect(model().attributeExists(USER_MODEL_ATTR));
    }

}
