package cy.meritkapital.tradevalidation.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateAfterOrEqDateValidator implements ConstraintValidator<DateAfterOrEqDate, Object> {

    private String smallDateStr;
    private String bigDateStr;

    @Override
    public void initialize(DateAfterOrEqDate constraintAnnotation) {
        this.smallDateStr = constraintAnnotation.smallDate();
        this.bigDateStr = constraintAnnotation.bigDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        LocalDate smallDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(smallDateStr);
        LocalDate bigDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(bigDateStr);

        return smallDate == null
                || bigDate == null
                || !bigDate.isBefore(smallDate);
    }

}
