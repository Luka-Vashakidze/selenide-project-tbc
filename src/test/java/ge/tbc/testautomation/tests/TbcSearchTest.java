package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.STREET_CHAVCHAVADZE;

public class TbcSearchTest extends BaseTest {


    @Test(groups = {"Search"}, description = "Search for street and validate that all results match")
    public void testSearchStreetResults() {

        homePageSteps.openLocationsPage();

        locationPageSteps
                .enterSearchValue(STREET_CHAVCHAVADZE)
                .validateResultsContainStreet(STREET_CHAVCHAVADZE);
    }

}
