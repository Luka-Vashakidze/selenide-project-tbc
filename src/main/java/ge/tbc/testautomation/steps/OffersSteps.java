package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.OffersPage;
import ge.tbc.testautomation.pages.OfferDetailsPage;

public class OffersSteps extends HomePageSteps {

    OffersPage offersPage;
    OfferDetailsPage offerDetailsPage;

    public OffersSteps(Page page) {
        super(page);
        this.offersPage = new OffersPage(page);
        this.offerDetailsPage = new OfferDetailsPage(page);
    }

    @Override
    public OffersSteps openHeaderForMeSection() {
        super.openHeaderForMeSection();
        return this;
    }

    public OffersSteps openOffersSection() {
        homePage.offersQuickAction.click();
        return this;
    }

    public OffersSteps clickMoreButton() {
        offersPage.moreButton.click();
        return this;
    }

    public OffersSteps filterAuto() {
        offersPage.autoFilterCheckbox.click();
        return this;
    }

    public OffersSteps openFirstOffer() {
        offersPage.firstOfferCard.click();
        return this;
    }

    public OffersSteps clickShare() {
        offerDetailsPage.shareButton.click();
        return this;
    }
    public OffersSteps filterByName(String filterName) {
        offersPage.filterCheckbox(filterName).click();
        return this;
    }
}
