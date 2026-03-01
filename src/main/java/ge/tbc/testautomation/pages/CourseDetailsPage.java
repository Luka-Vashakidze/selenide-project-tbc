package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class CourseDetailsPage {

    public Locator registrationButton;

    public CourseDetailsPage(Page page) {
        this.registrationButton = page.locator("//div[contains(@class,'button-wrapper')]//a[contains(@href,'forms')]");
    }
}
