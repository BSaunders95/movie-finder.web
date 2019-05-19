package uk.gov.companieshouse.moviefinder.web.model;

import javax.validation.constraints.NotNull;

public class Overview {

    @NotNull(message = "{noActionSelected}")
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
