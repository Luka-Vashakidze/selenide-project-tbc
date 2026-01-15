package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OfferDetailsPage {

    public SelenideElement shareButton = $x("//div[contains(@class,'app-textpage-bottom__share')]");
}
