package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    public HomePageSteps openHeaderForMeSection() {
        if (homePage.burgerMenu.is(visible)) {
            homePage.burgerMenu.click();
            homePage.forMeMenu.shouldBe(visible).click();
        } else {
            actions().moveToElement(homePage.forMeMenu.shouldBe(visible)).perform();
        }
        return this;
    }
    public HomePageSteps openConsumerLoanPage() {
        if (homePage.mobileLoansDropdown.is(visible)) {
            homePage.mobileLoansDropdown.click();
        }
        homePage.consumerLoanLink.shouldBe(visible).click();
        return this;
    }
    public HomePageSteps openLocationsPage() {
        homePage.locationsLink.shouldBe(visible).click();
        return this;
    }

    public HomePageSteps openTbcMenu() {
        if (homePage.burgerMenu.is(visible)) {
            homePage.burgerMenu.click();
            homePage.tbcMenu.shouldBe(visible).click();
        } else {
            actions().moveToElement(homePage.tbcMenu.shouldBe(visible)).perform();
        }
        return this;
    }

    public HomePageSteps openTechSchool() {
        homePage.techSchoolLink.scrollTo().shouldBe(visible).click();
            return this;

    }

}
