package cy.meritkapital.tradevalidation.controller;

import cy.meritkapital.tradevalidation.model.TradeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = {"Trade Validation"})
public class TradeValidationController {

    @PostMapping("/trade-validation")
    @ApiOperation(value = "Validate Trades", notes = "Accepts Trades in json format and return the validation result")
    public ResponseEntity<String> tradeValidation(@Valid @RequestBody TradeRequest trades) {
        return ResponseEntity.ok("All trades are valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
