package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class ConsumerLoanPage {

    public Locator conditionsButton;
    public Locator ctaSectionTitle;
    public Locator ctaListItems;

    public ConsumerLoanPage(Page page) {
        this.conditionsButton = page.locator("//a[@href='/ka/loans/consumer-loan/digital']/button");
        this.ctaSectionTitle = page.locator("h1.tbcx-pw-cta-section__info__title").first();
        this.ctaListItems = page.locator("span.tbcx-list-item__text").first();
    }

}
