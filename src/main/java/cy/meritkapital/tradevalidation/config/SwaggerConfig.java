package cy.meritkapital.tradevalidation.config;

import cy.meritkapital.tradevalidation.properties.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final ApiInfo defaultApiInfo;
    private final SwaggerProperties swaggerProperties;

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Collections.singletonList("application/json"));

    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        Contact defaultContact = new Contact(swaggerProperties.getName(),
                                             swaggerProperties.getWebsite(),
                                             swaggerProperties.getEmail());

        defaultApiInfo = new ApiInfo(swaggerProperties.getTitle(),
                                     swaggerProperties.getDescription(),
                                     swaggerProperties.getVersion(),
                                     swaggerProperties.getTermOfServiceUrl(),
                                     defaultContact,
                                     swaggerProperties.getLicence(),
                                     swaggerProperties.getLicenceUrl(),
                                     Collections.emptyList());

        this.swaggerProperties = swaggerProperties;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(defaultApiInfo)
                .tags(new Tag(swaggerProperties.getControllerName(), swaggerProperties.getControllerDescription()))
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .paths(regex("/actuator/shutdown*"))
                .build()
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder()
                                        .code(400)
                                        .message("Validation Error")
                                        .build()))
                ;
    }
}
