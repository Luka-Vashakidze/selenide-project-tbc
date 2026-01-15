package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LocationsPage {

    public SelenideElement searchInput = $("input.search-input");
    public ElementsCollection resultItems = $$(".tbcx-pw-atm-branches-section__list-item-title");

    public SelenideElement atmTab = $x("//button[contains(@class,'tbcx-pw-tab-menu__item')]//span[contains(text(),'ბანკომატები')]");

    public SelenideElement filter24_7 = $x("//span[contains(@class, 'tbcx-pw-chip__checkmark') and contains(text(),'24/7')]");

    public ElementsCollection itemDescriptions = $$(".tbcx-pw-atm-branches-section__list-item-description");

}