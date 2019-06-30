package cy.meritkapital.tradevalidation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "trade")
@Getter
@Setter
public class TradeProperties {
    private List<String> supportedCounterparties;
}
