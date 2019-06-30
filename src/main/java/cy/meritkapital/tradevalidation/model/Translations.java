
package cy.meritkapital.tradevalidation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "de",
    "es",
    "fr",
    "ja",
    "it",
    "br",
    "pt",
    "nl",
    "hr",
    "fa"
})
@Data
class Translations {

    @JsonProperty("de")
    private String de;
    @JsonProperty("es")
    private String es;
    @JsonProperty("fr")
    private String fr;
    @JsonProperty("ja")
    private String ja;
    @JsonProperty("it")
    private String it;
    @JsonProperty("br")
    private String br;
    @JsonProperty("pt")
    private String pt;
    @JsonProperty("nl")
    private String nl;
    @JsonProperty("hr")
    private String hr;
    @JsonProperty("fa")
    private String fa;

}
