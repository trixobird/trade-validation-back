package cy.meritkapital.tradevalidation;

import cy.meritkapital.tradevalidation.properties.SwaggerProperties;
import cy.meritkapital.tradevalidation.properties.TradeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties({SwaggerProperties.class, TradeProperties.class})
public class TradeValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeValidationApplication.class, args);
	}

}
