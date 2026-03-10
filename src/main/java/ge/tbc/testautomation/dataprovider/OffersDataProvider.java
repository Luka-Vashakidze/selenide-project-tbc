package ge.tbc.testautomation.dataprovider;

import org.testng.annotations.DataProvider;

public class OffersDataProvider {

    @DataProvider(name = "offersFilterSimple")
    public static Object[][] offersFilterSimpleProvider() {
        return new Object[][] {
                {"ავტო"},
                {"ტრანსპორტი"},
                {"განათლება"}
        };
    }
}
