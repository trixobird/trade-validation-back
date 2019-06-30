package cy.meritkapital.tradevalidation.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BetweenDateValidator implements ConstraintValidator<BetweenDate, Object> {

    private String smallDateStr;
    private String givenDateStr;
    private String bigDateStr;

    @Override
    public void initialize(BetweenDate constraint) {
        this.smallDateStr = constraint.smallDate();
        this.givenDateStr = constraint.givenDate();
        this.bigDateStr = constraint.bigDate();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        LocalDate smallDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(smallDateStr);
        LocalDate givenDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(givenDateStr);
        LocalDate bigDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(bigDateStr);

        if (givenDate == null) {
            return true;
        }

        return smallDate != null
            && bigDate != null
            && smallDate.isBefore(givenDate)
            && givenDate.isBefore(bigDate);
    }
}
