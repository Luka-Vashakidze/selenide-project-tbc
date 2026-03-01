package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import ge.tbc.testautomation.pages.ConsumerLoanPage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static ge.tbc.testautomation.data.Constants.TBC_BASE_URL;
import static org.testng.Assert.assertTrue;

public class ConsumerLoanPageSteps {
    ConsumerLoanPage loanPage;
    Page page;

    public ConsumerLoanPageSteps(Page page) {
        this.page = page;
        this.loanPage = new ConsumerLoanPage(page);
    }

    public ConsumerLoanPageSteps openLoanConditionsPage() {
        loanPage.conditionsButton.click();
        return this;
    }
    public ConsumerLoanPageSteps navigateToConsumerLoanPage() {
        page.navigate(TBC_BASE_URL + "/loans/consumer-loan");
        page.waitForLoadState();
        page.waitForTimeout(2000);
        return this;
    }

    public ConsumerLoanPageSteps validateTitleMatchesApi(String expectedTitle) {
        assertThat(loanPage.ctaSectionTitle).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        assertThat(loanPage.ctaSectionTitle).containsText(expectedTitle, new LocatorAssertions.ContainsTextOptions().setTimeout(10000));

        return this;
    }

    public ConsumerLoanPageSteps validateListItemMatchesApi(String expectedLabel) {
        assertThat(loanPage.ctaListItems.first()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        List<Locator> items = loanPage.ctaListItems.all();
        assertTrue(items.size() > 0);

        boolean found = items.stream().anyMatch(item ->
                {
                    String text = item.textContent();
                    return text != null && text.contains(expectedLabel);
                });

        assertTrue(found);

        return this;
    }
}