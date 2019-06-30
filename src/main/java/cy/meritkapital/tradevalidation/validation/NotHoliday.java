package cy.meritkapital.tradevalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotHolidayValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotHoliday {
    String dateProperty();
    String currencyProperty();

    String message() default "Date cannot fall on holiday";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
