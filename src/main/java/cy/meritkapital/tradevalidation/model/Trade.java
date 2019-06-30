package cy.meritkapital.tradevalidation.model;

import cy.meritkapital.tradevalidation.validation.annotation.SupportedCounterparty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ApiModel(description="Trade Model Detail")
public class Trade {
    @SupportedCounterparty
    private String customer;
    private String ccyPair;
    private EType type;
    private EDirection direction;
    @NotNull(message = "Please provide trade date")
    private LocalDate tradeDate;
    private double amount1;
    private double amount2;
    private BigDecimal rate;
    @NotNull(message = "Please provide value date")
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;
    private EStyle style;
    private EStrategy strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private BigDecimal premium;
    private String premiumCcy;
    private String premiumType;
    private LocalDate premiumDate;
}
