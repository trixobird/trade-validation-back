
package cy.meritkapital.tradevalidation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iso639_1",
    "iso639_2",
    "name",
    "nativeName"
})
class Language {

    @JsonProperty("iso639_1")
    private String iso6391;
    @JsonProperty("iso639_2")
    private String iso6392;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nativeName")
    private String nativeName;

}
