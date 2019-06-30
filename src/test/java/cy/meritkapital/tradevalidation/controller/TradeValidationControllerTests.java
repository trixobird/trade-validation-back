package cy.meritkapital.tradevalidation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cy.meritkapital.tradevalidation.model.Trade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TradeValidationControllerTests {

    private static String RESOURCES_DIRECTORY = "src/test/resources/cy/meritkapital/tradevalidation/controller/";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String url;
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    @Value("${local.server.port}")
    int port;

    public TradeValidationControllerTests() throws IOException {
    }

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
        ResponseEntity<List<Trade>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<>(){});

        // assert
        List<Trade> employees = response.getBody();
        assertNotNull(employees);
        assertEquals(15, employees.size());
    }
}
