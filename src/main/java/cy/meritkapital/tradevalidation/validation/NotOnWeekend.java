package cy.meritkapital.tradevalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotOnWeekendValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotOnWeekend {
    String message() default "Date cannot fall on weekend";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
