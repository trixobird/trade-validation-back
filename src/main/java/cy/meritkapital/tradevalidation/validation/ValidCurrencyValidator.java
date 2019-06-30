package cy.meritkapital.tradevalidation.validation;

import cy.meritkapital.tradevalidation.service.ICurrencyService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidCurrencyValidator implements ConstraintValidator<ValidCurrency, String> {

    private final ICurrencyService currencyService;

    public ValidCurrencyValidator(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {

        if (obj == null || obj.length() != 6) {
            return false;
        }

        String[] currencies = obj
                .toLowerCase()
                .split("(?<=\\G...)");

        return Arrays.stream(currencies).allMatch(currencyService::isValidCurrency);
    }
}
