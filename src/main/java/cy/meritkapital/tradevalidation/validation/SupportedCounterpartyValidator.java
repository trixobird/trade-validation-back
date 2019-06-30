package cy.meritkapital.tradevalidation.validation;

import cy.meritkapital.tradevalidation.properties.TradeProperties;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SupportedCounterpartyValidator implements ConstraintValidator<SupportedCounterparty, String> {

    private final TradeProperties tradeProperties;

    public SupportedCounterpartyValidator(TradeProperties tradeProperties) {
        this.tradeProperties = tradeProperties;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return tradeProperties.getSupportedCounterparties().contains(s);
    }
}
