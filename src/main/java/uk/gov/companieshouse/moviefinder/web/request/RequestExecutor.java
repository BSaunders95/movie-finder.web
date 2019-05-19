package uk.gov.companieshouse.moviefinder.web.request;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uk.gov.companieshouse.moviefinder.web.exception.GenericRequestException;
import uk.gov.companieshouse.moviefinder.web.exception.RequestNotFoundException;

@Component
public class RequestExecutor {

    private static final Logger logger = LogManager.getLogger(RequestExecutor.class);

    private static final String BASE_URL = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Executes a GET request and, if the request is successful, marshals the response body to
     * an object of a given {@code type}.
     *
     * @param uriSuffix The relative path for which to execute the request
     * @param type The type of object to which to deserialize the response body
     * @return an object of a given {@code type} containing data returned in the response body
     */
    public <T> T executeGetRequest(String uriSuffix, Class<T> type) {

        logger.info("Executing GET request on " + BASE_URL + uriSuffix);

        try {
            return restTemplate.getForEntity(new URI(BASE_URL + uriSuffix), type).getBody();

        } catch (URISyntaxException e) {

            throw new GenericRequestException(e);
        } catch (HttpClientErrorException e) {

            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RequestNotFoundException("Request to " + uriSuffix + " returned no data");
            }

            throw new GenericRequestException("Request to " + uriSuffix + " was unsuccessful");
        }
    }
}
