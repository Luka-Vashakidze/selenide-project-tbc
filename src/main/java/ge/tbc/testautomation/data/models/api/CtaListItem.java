package ge.tbc.testautomation.data.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CtaListItem {

    private String id;
    private String type;
    private String key;
    private String label;
    private String icon;
}