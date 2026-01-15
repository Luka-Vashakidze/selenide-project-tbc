package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement locationsLink = $x("//a[contains(text(),'მისამართები')]");

    public SelenideElement forMeMenu = $x("//div[contains(@class,'tbcx-pw-navigation-item__link') and contains(text(),'ჩემთვის')]");
    public SelenideElement offersLink = $x("//span[contains(text(),'შეთავაზებები')]");
    public SelenideElement consumerLoanLink = $x("//span[contains(text(),'სამომხმარებლო')]");
    public SelenideElement tbcMenu = $x("//div[contains(@class,'tbcx-pw-navigation-item__link') and normalize-space()='თიბისი']");

    public SelenideElement techSchoolLink = $x("//span[contains(@class,'tbcx-pw-mega-menu-sub-item__title') and text()='ტექსკოლა']");
    public SelenideElement burgerMenu = $x("//tbcx-icon[normalize-space()='burger-menu-alt-outlined']");
    public SelenideElement mobileLoansDropdown = $x("//button[.//span[normalize-space()='სესხები']]");
}