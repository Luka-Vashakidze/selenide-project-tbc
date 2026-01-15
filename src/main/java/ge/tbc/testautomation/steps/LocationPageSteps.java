package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.LocationsPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbc.testautomation.data.Constants.ATM_TEXT;
import static ge.tbc.testautomation.data.Constants.FILTER_24_7;

public class LocationPageSteps {

    LocationsPage locationsPage = new LocationsPage();

    public LocationPageSteps enterSearchValue(String street) {
        locationsPage.searchInput.shouldBe(visible)
                .setValue(street)
                .pressEnter();
        return this;
    }

    public LocationPageSteps validateResultsContainStreet(String street) {
        locationsPage.resultItems.shouldHave(sizeGreaterThan(0));

        for (SelenideElement item : locationsPage.resultItems) {
            item.scrollTo()
                    .shouldBe(visible)
                    .shouldHave(text(street));
        }
        return this;
    }

    //


    public LocationPageSteps clickAtmTab() {
        locationsPage.atmTab.shouldBe(visible).click();
        return this;
    }

    public LocationPageSteps enable24_7Filter() {
        locationsPage.filter24_7.shouldBe(visible).click();
        return this;
    }

    public LocationPageSteps validateAllAreATM24_7() {
        locationsPage.itemDescriptions.shouldHave(sizeGreaterThan(0));

        for (SelenideElement desc : locationsPage.itemDescriptions) {
            desc.shouldBe(visible).shouldHave(text(ATM_TEXT)).shouldHave(text(FILTER_24_7));
        }
        return this;
    }

}
