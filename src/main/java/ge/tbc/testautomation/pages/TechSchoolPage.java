package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TechSchoolPage {
    Page page;

    public Locator courseCards;

    public Locator courseLinkByIndex(int index) {
        return page.locator("(//div[contains(@class,'tbcx-pw-carousel__card')]//a)[" + index + "]");
    }

    public TechSchoolPage(Page page) {
        this.page = page;
        this.courseCards = page.locator("//div[contains(@class,'tbcx-pw-carousel__card')]");
    }
}
