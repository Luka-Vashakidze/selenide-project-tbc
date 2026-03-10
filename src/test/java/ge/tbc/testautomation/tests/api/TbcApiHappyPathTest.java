package ge.tbc.testautomation.tests.api;

import ge.tbc.testautomation.data.models.api.PageResponse;
import ge.tbc.testautomation.steps.ApiSteps;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

public class TbcApiHappyPathTest {

    private ApiSteps apiSteps;

    @BeforeClass
    public void setUp() {
        apiSteps = new ApiSteps();
    }

    @Test(groups = {"api"}, description = "Happy path: GET consumer loan page returns 200 and correct field values")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetConsumerLoanPageReturns200() {

        Response response = apiSteps.getPageById(CONSUMER_LOAN_PAGE_ID);
        apiSteps.assertStatusCode(response, 200);

        PageResponse pageResponse = apiSteps.deserialize(response);
        String title = apiSteps.extractTitle(pageResponse);

        String listItemLabel = apiSteps.extractFirstListItemLabel(pageResponse);

        apiSteps.assertTitleEquals(title, EXPECTED_CONSUMER_LOAN_TITLE);

        apiSteps.assertListItemLabelNotBlank(listItemLabel);

        System.out.println("API title: " + title);
        System.out.println("API list item: " + listItemLabel);
    }
}