package cy.meritkapital.tradevalidation.controller;

import cy.meritkapital.tradevalidation.model.Trade;
import cy.meritkapital.tradevalidation.model.TradeValidationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"Trade Validation"})
public class TradeValidationController {

    @PostMapping("/trade-validation")
    @ApiOperation(value = "Validate Trades", notes = "Accepts Trades in json format and return the validation result")
    public TradeValidationResponse tradeValidation(@RequestBody List<Trade> trades) {
        return new TradeValidationResponse(true);
    }
}
