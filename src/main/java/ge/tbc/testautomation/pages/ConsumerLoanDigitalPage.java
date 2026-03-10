package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class ConsumerLoanDigitalPage {

        public Locator amountInput;

        public Locator durationInput;

        public Locator paymentDigits;

        public ConsumerLoanDigitalPage(Page page) {
                this.amountInput = page.locator("//input[@type='number' and @min='200' and @max='80000']");
                this.durationInput = page.locator("//input[@type='number' and @min='3' and @max='48']");
                this.paymentDigits = page.locator("//div[contains(@class,'tbcx-pw-calculated-info__number--new')]/span[not(contains(text(),'₾'))]");
        }
}
