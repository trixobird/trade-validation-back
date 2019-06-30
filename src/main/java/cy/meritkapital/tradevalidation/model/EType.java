package cy.meritkapital.tradevalidation.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum  EType {
    SPOT("Spot"),
    FORWARD("Forward"),
    VANILLA_OPTION("VanillaOption");

    @JsonValue
    private String value;

    EType(String value) {
        this.value = value;
    }
}
