package cy.meritkapital.tradevalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateAfterOrEqDateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAfterOrEqDate {

    String message() default "Small Date is after big date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String smallDate();
    String bigDate();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        DateAfterOrEqDate[] value();
    }
}
