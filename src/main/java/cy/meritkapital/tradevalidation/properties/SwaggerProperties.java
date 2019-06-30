package cy.meritkapital.tradevalidation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "swagger")
@Getter
@Setter
public class SwaggerProperties {
    private String title;
    private String description;
    private String version;
    private String name;
    private String website;
    private String email;
    private String licence;
    private String licenceUrl;
    private String termOfServiceUrl;
    private String controllerName;
    private String controllerDescription;
}
