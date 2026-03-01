package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class HomePage {
    public Locator forMeNavItem;
    public Locator tbcNavItem;
    public Locator consumerLoanLink;
    public Locator techSchoolLink;
    public Locator locationsQuickAction;
    public Locator offersQuickAction;
    public Locator burgerMenu;
    public Locator mobileForMeButton;
    public Locator mobileTbcButton;
    public Locator mobileLoansAccordion;

    public HomePage(Page page) {

        Locator desktopNav = page.locator("tbcx-pw-navigation.show-desktop-only");
        this.forMeNavItem = desktopNav.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("ჩემთვის"));
        this.tbcNavItem = desktopNav.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("თიბისი"));

        this.consumerLoanLink = page.locator("a[href='/ka/loans/consumer-loan'] .tbcx-pw-mega-menu-sub-item__title");
        this.techSchoolLink = page.locator("a[href='/ka/tbc-education/tech-school'] .tbcx-pw-mega-menu-sub-item__title");

        Locator desktopAdditional = page.locator(".tbcx-pw-mega-menu__additional.show-desktop-up").first();
        this.locationsQuickAction = desktopAdditional.locator("a[href='/ka/atms&branches']");
        this.offersQuickAction = desktopAdditional.locator("a[href='/ka/offers']");

        this.burgerMenu = page.locator("tbcx-pw-hamburger-menu.show-mobile-only button");
        Locator megaMenuNav = page.locator(".tbcx-pw-mega-menu-navigation");
        this.mobileForMeButton = megaMenuNav.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("ჩემთვის"));
        this.mobileTbcButton = megaMenuNav.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("თიბისი"));
        this.mobileLoansAccordion = page.locator("tbcx-pw-accordion-item button:has(.tbcx-pw-mega-menu-sub-item__title:text('სესხები'))");
    }
}