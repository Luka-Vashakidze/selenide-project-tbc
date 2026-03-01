package ge.tbc.testautomation.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.tbc.testautomation.data.models.api.PageResponse;
import ge.tbc.testautomation.data.models.api.SectionComponent;
import io.restassured.response.Response;

import static ge.tbc.testautomation.data.Constants.API_BASE_URL;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ApiSteps {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Response getPageById(String pageId) {
        return given()
                .baseUri(API_BASE_URL)
                .queryParam("locale", "ka-GE")
                .header("Accept", "application/json")
                .log().uri()
                .when()
                .get("/pages/{pageId}", pageId)
                .then()
                .log().status()
                .extract()
                .response();
    }

    public PageResponse deserialize(Response response) {
        try {
            return objectMapper.readValue(response.asString(), PageResponse.class);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public String extractTitle(PageResponse pageResponse) {
        SectionComponent firstSection = pageResponse.getSectionComponents().get(0);
        return firstSection.getInputs().getTitle();
    }

    public String extractFirstListItemLabel(PageResponse pageResponse) {
        SectionComponent firstSection = pageResponse.getSectionComponents().get(0);
        return firstSection.getInputs().getList().get(0).getLabel();
    }

    public ApiSteps assertStatusCode(Response response, int expectedCode) {
        assertEquals(response.getStatusCode(), expectedCode);
        return this;
    }

    public ApiSteps assertTitleEquals(String actualTitle, String expectedTitle) {
        assertEquals(actualTitle, expectedTitle);
        return this;
    }

    public ApiSteps assertListItemLabelNotBlank(String label) {
        assertNotNull(label);
        assertFalse(label.isBlank());
        return this;
    }
}