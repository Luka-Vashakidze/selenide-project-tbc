package ge.tbc.testautomation.tests.api;

import ge.tbc.testautomation.steps.ApiSteps;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.INVALID_PAGE_ID;

public class TbcApiNegativeTest {

    private ApiSteps apiSteps;

    @BeforeClass
    public void setUp() {
        apiSteps = new ApiSteps();
    }

    @Test(groups = {"api"}, description = "Negative path: GET with invalid pageId returns 404")
    @Severity(SeverityLevel.NORMAL)
    public void testGetInvalidPageIdReturns404() {

        Response response = apiSteps.getPageById(INVALID_PAGE_ID);

        apiSteps.assertStatusCode(response, 404);
    }
}