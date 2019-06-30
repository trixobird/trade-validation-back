package cy.meritkapital.tradevalidation.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Trade {
    private String customer;
    private String ccyPair;
    private EType type;
    private EDirection direction;
    private LocalDate tradeDate;
    private double amount1;
    private double amount2;
    private BigDecimal rate;
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
