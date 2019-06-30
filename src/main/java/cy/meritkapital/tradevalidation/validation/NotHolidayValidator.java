package cy.meritkapital.tradevalidation.validation;

import cy.meritkapital.tradevalidation.properties.TradeProperties;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class NotHolidayValidator implements ConstraintValidator<NotHoliday, Object> {

    private final TradeProperties tradeProperties;
    private String dateProperty;
    private String currencyProperty;

    public NotHolidayValidator(TradeProperties tradeProperties) {
        this.tradeProperties = tradeProperties;
    }

    @Override
    public void initialize(NotHoliday constraintAnnotation) {
        this.dateProperty = constraintAnnotation.dateProperty();
        this.currencyProperty = constraintAnnotation.currencyProperty();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        LocalDate date = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(dateProperty);
        String[] currencies = ((String) new BeanWrapperImpl(value).getPropertyValue(currencyProperty))
                              .toLowerCase()
                              .split("(?<=\\G...)");

        if (!Arrays.stream(currencies).allMatch(c -> tradeProperties.getHolidays().containsKey(c))) {
            return false;
        }

        return (Arrays.stream(currencies).noneMatch(c -> tradeProperties.getHolidays().get(c).contains(date)));
    }
}
