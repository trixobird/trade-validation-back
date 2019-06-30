package cy.meritkapital.tradevalidation.validation;

import cy.meritkapital.tradevalidation.model.EStyle;
import org.apache.commons.lang3.EnumUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidStyleValidator implements ConstraintValidator<ValidStyle, String> {

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return EnumUtils.isValidEnum(EStyle.class, obj);
   }
}
