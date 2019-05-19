package uk.gov.companieshouse.moviefinder.web.service;

import uk.gov.companieshouse.moviefinder.web.model.User;

public interface UserService {

    /**
     * Fetches the user with the most comments
     *
     * @return the {@link User} with the most comments
     */
    User getUserWithMostComments();
}
