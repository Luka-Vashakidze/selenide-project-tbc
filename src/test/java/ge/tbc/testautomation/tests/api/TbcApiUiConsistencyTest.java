package ge.tbc.testautomation.tests.api;

import ge.tbc.testautomation.data.models.api.PageResponse;
import ge.tbc.testautomation.steps.ApiSteps;
import ge.tbc.testautomation.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.CONSUMER_LOAN_PAGE_ID;

public class TbcApiUiConsistencyTest extends BaseTest {

    private final ApiSteps apiSteps = new ApiSteps();

    @Test(groups = {"api", "api-ui"}, description = "API UI consistency: consumer loan page title and list item match API response")
    @Severity(SeverityLevel.CRITICAL)
    public void testConsumerLoanApiUiConsistency() {

        Response response = apiSteps.getPageById(CONSUMER_LOAN_PAGE_ID);

        apiSteps.assertStatusCode(response, 200);
        PageResponse pageResponse = apiSteps.deserialize(response);

        String apiTitle = apiSteps.extractTitle(pageResponse);
        String apiListItemLabel = apiSteps.extractFirstListItemLabel(pageResponse);

        System.out.println(" API title: " + apiTitle);
        System.out.println("API list item:  " + apiListItemLabel);

        consumerLoanPageSteps.navigateToConsumerLoanPage();

        consumerLoanPageSteps.validateTitleMatchesApi(apiTitle);

        consumerLoanPageSteps.validateListItemMatchesApi(apiListItemLabel);

        System.out.println("UI title matches API title: " + apiTitle);
        System.out.println("UI list item matches API label: " + apiListItemLabel);
    }
}