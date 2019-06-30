package cy.meritkapital.tradevalidation.controller;

import cy.meritkapital.tradevalidation.model.Trade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TradeValidationControllerIntegrationTests {

    private static String RESOURCES_DIRECTORY = "src/test/resources/cy/meritkapital/tradevalidation/controller/";
    private String url;
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    @Value("${local.server.port}")
    int port;

    @Before
    public void init() {
        url = "http://localhost:" + port + "/trade-validation";
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void tradeValidation_validJson_allTrades() throws IOException {
        // when
        String trades = new String(Files.readAllBytes(Paths.get(RESOURCES_DIRECTORY + "trades.json")));
        HttpEntity<String> request = new HttpEntity<>(trades, headers);

        // act
        try {
            restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<>(){});
        } catch (RestClientException e) {
            String[] errors = ((HttpClientErrorException.BadRequest) e)
                    .getResponseBodyAsString()
                    .split(",");

            assertEquals(10, errors.length);
        }
    }
}
