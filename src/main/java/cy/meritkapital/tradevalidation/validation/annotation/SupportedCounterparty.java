package cy.meritkapital.tradevalidation.validation.annotation;

import cy.meritkapital.tradevalidation.validation.SupportedCounterpartyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SupportedCounterpartyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedCounterparty {
    String message() default "The counterparty is not one of the supported ones";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
