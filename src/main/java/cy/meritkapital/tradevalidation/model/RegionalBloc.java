
package cy.meritkapital.tradevalidation.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acronym",
    "name",
    "otherAcronyms",
    "otherNames"
})
class RegionalBloc {

    @JsonProperty("acronym")
    private String acronym;
    @JsonProperty("name")
    private String name;
    @JsonProperty("otherAcronyms")
    private List<Object> otherAcronyms = null;
    @JsonProperty("otherNames")
    private List<Object> otherNames = null;

}
