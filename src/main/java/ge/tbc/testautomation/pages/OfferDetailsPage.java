package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class OfferDetailsPage {

    public Locator shareButton;

    public OfferDetailsPage(Page page) {
        this.shareButton = page.locator("//div[contains(@class,'app-textpage-bottom__share')]");
    }
}
