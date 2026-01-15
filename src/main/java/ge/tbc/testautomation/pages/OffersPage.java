package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class OffersPage {

    public SelenideElement moreButton = $x("//button[contains(text(),'ვრცლად')]");
    public SelenideElement autoFilterCheckbox = $x("//div[contains(@class,'filter-item__label')]//input[@type='checkbox']/following-sibling::text()[contains(.,'ავტო')]/..");

    public SelenideElement firstOfferCard = $x("(//a[tbcx-pw-card])[1]");
}
