package uk.gov.companieshouse.moviefinder.web.exception;

public class GenericRequestException extends RuntimeException {

    public GenericRequestException(Exception e) {
        super(e);
    }

    public GenericRequestException(String message) {
        super(message);
    }
}
