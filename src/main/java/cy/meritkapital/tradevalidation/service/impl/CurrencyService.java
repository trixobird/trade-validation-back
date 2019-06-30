package cy.meritkapital.tradevalidation.service.impl;

import cy.meritkapital.tradevalidation.model.Currency;
import cy.meritkapital.tradevalidation.model.Currency_;
import cy.meritkapital.tradevalidation.service.ICurrencyService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.Cacheable;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyService implements ICurrencyService {

    private static final String URI = "https://restcountries.eu/rest/v2/all";

    @Override
    public boolean isValidCurrency(String currency) {
        return getAllCurrencies()
                .stream()
                .anyMatch(currency::equalsIgnoreCase);
    }

    @Cacheable("currencies")
    private Set<String> getAllCurrencies() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Currency>> response = restTemplate.exchange(
                URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});

        if (response.getStatusCode() != HttpStatus.OK
        || response.getBody() == null) {
            return Collections.emptySet();
        }

        return response
                .getBody()
                .stream()
                .map(c -> c.getCurrencies().stream().map(Currency_::getCode))
                .flatMap(t -> t)
                .collect(Collectors.toSet());
    }
}
