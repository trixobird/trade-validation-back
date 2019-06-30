package cy.meritkapital.tradevalidation.validation;

import cy.meritkapital.tradevalidation.model.Trade;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateAfterDateValidator implements ConstraintValidator<DateAfterDate, Trade> {
   private String smallDateStr;
   private String bigDateStr;

   @Override
   public void initialize(DateAfterDate constraintAnnotation) {
      this.smallDateStr = constraintAnnotation.smallDate();
      this.bigDateStr = constraintAnnotation.bigDate();
   }

   @Override
   public boolean isValid(Trade value, ConstraintValidatorContext context) {

      LocalDate smallDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(smallDateStr);
      LocalDate bigDate = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(bigDateStr);

      if (bigDate == null || smallDate == null) {
         return true;
      }

      return bigDate.isAfter(smallDate);
   }
}
