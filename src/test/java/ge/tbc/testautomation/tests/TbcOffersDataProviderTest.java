package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.dataprovider.OffersDataProvider;
import org.testng.annotations.Test;

public class TbcOffersDataProviderTest extends BaseTest {

    @Test(groups = {"offers"}, dataProvider = "offersFilterSimple", dataProviderClass = OffersDataProvider.class, description = "Filter offers by category using DataProvider")
    public void testOffersFilterWithDataProvider(String filterName) {
        offersSteps
                .openHeaderForMeSection()
                .openOffersSection()
                .clickMoreButton()
                .filterByName(filterName);
    }
}