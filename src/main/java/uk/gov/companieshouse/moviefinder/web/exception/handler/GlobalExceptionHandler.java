package uk.gov.companieshouse.moviefinder.web.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.gov.companieshouse.moviefinder.web.exception.GenericRequestException;
import uk.gov.companieshouse.moviefinder.web.exception.RequestNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    private static final String ERROR_VIEW = "error";
    private static final String NOT_FOUND_VIEW = "notFound";

    @ExceptionHandler(RequestNotFoundException.class)
    protected String handleRequestNotFoundException(Exception ex) {

        logger.error("Request returned not found response", ex);
        return NOT_FOUND_VIEW;
    }

    @ExceptionHandler(GenericRequestException.class)
    protected String handleGenericRequestException(Exception ex) {

        logger.error("An exception occurred when executing a request", ex);
        return ERROR_VIEW;
    }

    @ExceptionHandler(Exception.class)
    protected String handleException(Exception ex) {

        logger.error("An exception has occurred", ex);
        return ERROR_VIEW;
    }
}
