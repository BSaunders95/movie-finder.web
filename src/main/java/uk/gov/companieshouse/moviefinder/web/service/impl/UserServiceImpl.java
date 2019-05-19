package uk.gov.companieshouse.moviefinder.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.companieshouse.moviefinder.web.model.User;
import uk.gov.companieshouse.moviefinder.web.request.RequestExecutor;
import uk.gov.companieshouse.moviefinder.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RequestExecutor requestExecutor;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserWithMostComments() {

        return requestExecutor.executeGetRequest("/users/most-comments", User.class);
    }
}
