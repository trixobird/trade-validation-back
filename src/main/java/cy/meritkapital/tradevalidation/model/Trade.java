package cy.meritkapital.tradevalidation.model;

import cy.meritkapital.tradevalidation.validation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ApiModel(description = "Trade Model Detail")
@DateAfterOrEqDate(
        smallDate = "tradeDate",
        bigDate = "valueDate",
        message = "Value dateProperty cannot be before trade dateProperty")
@NotHoliday(dateProperty = "valueDate",
        currencyProperty = "ccyPair",
        message = "Value Date cannot fall on holiday",
        groups = {Extended.class})
public class Trade {
    @SupportedCounterparty
    private String customer;
    @ValidCurrency
    private String ccyPair;
    private EType type;
    private EDirection direction;
    @NotNull(message = "Please provide trade dateProperty")
    private LocalDate tradeDate;
    private double amount1;
    private double amount2;
    private BigDecimal rate;
    @NotNull(message = "Please provide value dateProperty")
    @NotOnWeekend(message = " Value dateProperty cannot fall on weekend")
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;
    @ValidStyle
    private String style;
    private EStrategy strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private BigDecimal premium;
    private String premiumCcy;
    private String premiumType;
    private LocalDate premiumDate;
}
