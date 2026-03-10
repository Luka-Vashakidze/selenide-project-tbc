package ge.tbc.testautomation.data.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionComponent {

    private String id;
    private String type;
    private String key;
    private CtaSectionInputs inputs;
}