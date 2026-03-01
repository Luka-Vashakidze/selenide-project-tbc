package ge.tbc.testautomation.data.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CtaSectionInputs {

    private String id;
    private String type;
    private String key;
    private String title;
    private String bodyText;
    private List<CtaListItem> list;
}