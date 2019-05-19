package uk.gov.companieshouse.moviefinder.web.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uk.gov.companieshouse.moviefinder.web.exception.GenericRequestException;
import uk.gov.companieshouse.moviefinder.web.exception.RequestNotFoundException;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RequestExecutorTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RequestExecutor requestExecutor;

    @Mock
    private ResponseEntity<Object> response;

    @Mock
    private Object object;

    @Mock
    private HttpClientErrorException httpClientErrorException;

    private static final String BASE_URL = "http://localhost:8080";

    private static final String URI_SUFFIX = "/uri-suffix";

    @Test
    @DisplayName("Execute GET request - success")
    void executeGetRequestSuccess() throws URISyntaxException {

        when(restTemplate.getForEntity(new URI(BASE_URL + URI_SUFFIX), Object.class))
                .thenReturn(response);

        when(response.getBody()).thenReturn(object);

        Object returnedObject = requestExecutor.executeGetRequest(URI_SUFFIX, Object.class);

        assertEquals(object, returnedObject);
    }

    @Test
    @DisplayName("Execute GET request - not found")
    void executeGetRequestNotFound() throws URISyntaxException {

        when(restTemplate.getForEntity(new URI(BASE_URL + URI_SUFFIX), Object.class))
                .thenThrow(httpClientErrorException);

        when(httpClientErrorException.getStatusCode()).thenReturn(HttpStatus.NOT_FOUND);

        assertThrows(RequestNotFoundException.class, () ->
                requestExecutor.executeGetRequest(URI_SUFFIX, Object.class));
    }

    @Test
    @DisplayName("Execute GET request - internal server error")
    void executeGetRequestInternalServerError() throws URISyntaxException {

        when(restTemplate.getForEntity(new URI(BASE_URL + URI_SUFFIX), Object.class))
                .thenThrow(httpClientErrorException);

        when(httpClientErrorException.getStatusCode()).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR);

        assertThrows(GenericRequestException.class, () ->
                requestExecutor.executeGetRequest(URI_SUFFIX, Object.class));
    }
}
