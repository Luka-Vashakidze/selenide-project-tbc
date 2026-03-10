package ge.tbc.testautomation.data.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponse {

    private String id;
    private String type;
    private String slug;

    @JsonProperty("sectionComponents")
    private List<SectionComponent> sectionComponents;
}