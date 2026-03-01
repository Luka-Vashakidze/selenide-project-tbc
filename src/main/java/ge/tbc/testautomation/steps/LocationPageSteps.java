package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import ge.tbc.testautomation.pages.LocationsPage;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static ge.tbc.testautomation.data.Constants.ATM_TEXT;
import static ge.tbc.testautomation.data.Constants.FILTER_24_7;
import static org.testng.Assert.assertTrue;

public class LocationPageSteps {

    LocationsPage locationsPage;
    Page page;

    public LocationPageSteps(Page page) {
        this.page = page;
        this.locationsPage = new LocationsPage(page);
    }

    public LocationPageSteps enterSearchValue(String street) {
        locationsPage.searchInput.click();
        locationsPage.searchInput.fill(street);
        locationsPage.searchInput.press("Enter");
        page.waitForTimeout(3000);
        return this;
    }

    public LocationPageSteps validateResultsContainStreet(String street) {
        assertThat(locationsPage.resultItems.first()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        for (Locator item : locationsPage.resultItems.all()) {
            item.scrollIntoViewIfNeeded();
            assertThat(item).isVisible();
            assertThat(item).containsText(street);
        }
        return this;
    }

    public LocationPageSteps validateMinimumResultsCount(int expectedMinResults) {
        assertThat(locationsPage.resultItems.first()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        int actualCount = locationsPage.resultItems.count();
        assertTrue(actualCount >= expectedMinResults);
        return this;
    }

    public LocationPageSteps clickAtmTab() {
        locationsPage.atmTab.click();
        page.waitForTimeout(3000);
        return this;
    }

    public LocationPageSteps enable24_7Filter() {
        locationsPage.filter24_7.click();
        page.waitForTimeout(3000);
        return this;
    }

    public LocationPageSteps validateAllAreATM24_7() {
        assertThat(locationsPage.itemDescriptions.first())
                .isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(20000));

        for (Locator desc : locationsPage.itemDescriptions.all()) {
            assertThat(desc).isVisible();
            assertThat(desc).containsText(ATM_TEXT);
            assertThat(desc).containsText(FILTER_24_7);
        }
        return this;
    }
}
