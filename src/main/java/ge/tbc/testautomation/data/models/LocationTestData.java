package ge.tbc.testautomation.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationTestData {
    private int id;
    private String area;
    private int expectedMinResults;
}
