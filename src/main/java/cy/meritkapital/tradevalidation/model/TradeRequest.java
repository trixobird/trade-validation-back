package cy.meritkapital.tradevalidation.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@ApiModel(description="Trade Request Detail")
public class TradeRequest {
    @Valid
    private List<Trade> trades;
}
