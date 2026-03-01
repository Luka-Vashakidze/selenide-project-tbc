package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.dataprovider.LocationDataProvider;
import org.testng.annotations.Test;

public class TbcLocationSqlTest extends BaseTest {

    @Test(groups = {"location-sql"}, dataProvider = "locationDataFromDb", dataProviderClass = LocationDataProvider.class, description = "Search for location using SQL parametrized data and validate results count")
    public void testLocationSearchWithSqlData(String area, int expectedMinResults) {
        homePageSteps.openLocationsPage();

        locationPageSteps
                .enterSearchValue(area)
                .validateMinimumResultsCount(expectedMinResults);
    }
}
