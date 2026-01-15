package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.pages.OffersPage;
import ge.tbc.testautomation.pages.OfferDetailsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class OffersSteps extends HomePageSteps{

    OffersPage offersPage = new OffersPage();
    OfferDetailsPage offerDetailsPage = new OfferDetailsPage();

    public OffersSteps openHeaderForMeSection() {
        actions().moveToElement(homePage.forMeMenu.shouldBe(visible)).perform();

        return this;
    }
    public OffersSteps openOffersSection() {
        homePage.offersLink.shouldBe(visible).click();

        return this;
    }

    public OffersSteps clickMoreButton() {
        offersPage.moreButton.shouldBe(visible).click();
        return this;
    }

    public OffersSteps filterAuto() {
        offersPage.autoFilterCheckbox.shouldBe(visible).click();
        return this;
    }

    public OffersSteps openFirstOffer() {
        offersPage.firstOfferCard.shouldBe(visible).click();
        return this;
    }

    public OffersSteps clickShare() {
        offerDetailsPage.shareButton.shouldBe(visible).click();
        return this;
    }
}
