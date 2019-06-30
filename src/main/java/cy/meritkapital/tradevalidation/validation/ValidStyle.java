package cy.meritkapital.tradevalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidStyleValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStyle {
    String message() default "The style is not one of the supported ones";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
