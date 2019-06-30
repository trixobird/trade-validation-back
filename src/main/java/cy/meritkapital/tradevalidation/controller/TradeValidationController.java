package cy.meritkapital.tradevalidation.controller;

import cy.meritkapital.tradevalidation.model.TradeRequest;
import cy.meritkapital.tradevalidation.validation.GroupSequenceForCcy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = {"Trade Validation"})
@Validated
public class TradeValidationController {

    @PostMapping("/trade-validation")
    @ApiOperation(value = "Validate Trades", notes = "Accepts Trades in json format and return the validation result")
    public ResponseEntity<String> tradeValidation(@Validated(GroupSequenceForCcy.class) @RequestBody TradeRequest trades) {
        return ResponseEntity.ok("All trades are valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        var errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName + ": " + errorMessage);
        });
        return errors;
    }
}
