package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.HomePage;

public class HomePageSteps {

    HomePage homePage;
    Page page;

    public HomePageSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    boolean isMobileViewport() {
        return page.viewportSize().width < 1024;
    }

    public HomePageSteps openHeaderForMeSection() {
        if (isMobileViewport()) {
            homePage.burgerMenu.click();
            homePage.mobileForMeButton.click();
        } else {
            homePage.forMeNavItem.hover();
        }
        return this;
    }

    public HomePageSteps openConsumerLoanPage() {
        if (isMobileViewport()) {
            homePage.mobileLoansAccordion.click();
        } else {
            homePage.forMeNavItem.hover();
        }
        homePage.consumerLoanLink.click();
        return this;
    }

    public HomePageSteps openLocationsPage() {
        if (isMobileViewport()) {
            homePage.burgerMenu.click();
            homePage.locationsQuickAction.click();
        } else {
            homePage.forMeNavItem.hover();
            homePage.locationsQuickAction.click();
        }
        return this;
    }

    public HomePageSteps openTbcMenu() {
        if (isMobileViewport()) {
            homePage.burgerMenu.click();
            homePage.mobileTbcButton.click();
        } else {
            homePage.tbcNavItem.hover();
        }
        return this;
    }

    public HomePageSteps openTechSchool() {
        homePage.techSchoolLink.click();
        return this;
    }
}
