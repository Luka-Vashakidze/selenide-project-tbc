package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class OffersPage {
    Page page;

    public Locator moreButton;
    public Locator autoFilterCheckbox;
    public Locator firstOfferCard;

    public OffersPage(Page page) {
        this.page = page;
        this.moreButton = page.locator("tbcx-pw-slider").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("ვრცლად"));
        this.autoFilterCheckbox = page.locator(".filter-item").filter(new Locator.FilterOptions().setHasText("ავტო")).locator("input[type='checkbox']");
        this.firstOfferCard = page.locator("//a[tbcx-pw-card]").first();
    }
    public Locator filterCheckbox(String filterName) {
        return page.locator(".filter-item")
                .filter(new Locator.FilterOptions().setHasText(filterName))
                .locator("input[type='checkbox']");
    }
}
