package cy.meritkapital.tradevalidation;

import cy.meritkapital.tradevalidation.properties.SwaggerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SwaggerProperties.class)
public class TradeValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeValidationApplication.class, args);
	}

}
