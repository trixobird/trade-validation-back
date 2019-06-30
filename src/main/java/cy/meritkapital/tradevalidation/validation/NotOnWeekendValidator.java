package cy.meritkapital.tradevalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class NotOnWeekendValidator implements ConstraintValidator<NotOnWeekend, LocalDate> {

    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day != DayOfWeek.SATURDAY
                && day != DayOfWeek.SUNDAY;
    }
}
