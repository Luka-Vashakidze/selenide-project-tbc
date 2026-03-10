package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class TbcAtmFilterTest extends BaseTest {

    @Test(groups = {"atm-filter"}, description = "Filter by ATM + 24/7 and validate results")
    public void testAtm24_7Filter() {

        homePageSteps.openLocationsPage();

        locationPageSteps
                .clickAtmTab()
                .enable24_7Filter()
                .validateAllAreATM24_7();
    }
}
