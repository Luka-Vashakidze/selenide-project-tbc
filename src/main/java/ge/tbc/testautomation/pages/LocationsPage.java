package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationsPage {

    public Locator searchInput;
    public Locator resultItems ;
    public Locator atmTab;
    public Locator filter24_7;

    public Locator itemDescriptions;

    public LocationsPage(Page page) {
        this.searchInput = page.locator("input.search-input");
        this.resultItems = page.locator(".tbcx-pw-atm-branches-section__list-item-title");
        this.atmTab = page.locator("//button[contains(@class,'tbcx-pw-tab-menu__item')]//span[contains(text(),'ბანკომატები')]");
        this.filter24_7 = page.locator("//span[contains(@class, 'tbcx-pw-chip__checkmark') and contains(text(),'24/7')]");
        this.itemDescriptions = page.locator(".tbcx-pw-atm-branches-section__list-item-description");
    }
}