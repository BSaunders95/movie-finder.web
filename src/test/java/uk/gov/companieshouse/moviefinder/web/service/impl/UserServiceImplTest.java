package uk.gov.companieshouse.moviefinder.web.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.companieshouse.moviefinder.web.model.User;
import uk.gov.companieshouse.moviefinder.web.request.RequestExecutor;
import uk.gov.companieshouse.moviefinder.web.service.UserService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    @Mock
    private RequestExecutor requestExecutor;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private User user;

    @Test
    @DisplayName("Get the user with the most comments")
    void getUserWithMostComments() {

        when(requestExecutor.executeGetRequest("/users/most-comments", User.class))
                .thenReturn(user);

        User returnedUser = userService.getUserWithMostComments();

        assertEquals(user, returnedUser);
    }
}
