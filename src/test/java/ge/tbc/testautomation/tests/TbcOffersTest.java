package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class TbcOffersTest extends BaseTest {

    @Test(groups = {"offers"}, description = "Navigate to Offers,Filter Auto, Open first offer, Share")
    public void testAutoOffersShareFlow() {

        offersSteps
                .openHeaderForMeSection()
                .openOffersSection()
                .clickMoreButton()
                .filterAuto()
                .openFirstOffer()
                .clickShare();
    }
}
