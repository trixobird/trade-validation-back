package cy.meritkapital.tradevalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BetweenDateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BetweenDate {

    String message() default "Date is not between given dates";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String smallDate();
    String givenDate();
    String bigDate();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        BetweenDate[] value();
    }
}
