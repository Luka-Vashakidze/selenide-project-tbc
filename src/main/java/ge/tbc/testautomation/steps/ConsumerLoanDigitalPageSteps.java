package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ConsumerLoanDigitalPage;
import org.testng.Assert;


public class ConsumerLoanDigitalPageSteps {
    ConsumerLoanDigitalPage loanDigitalPage;

    public ConsumerLoanDigitalPageSteps(Page page) {
        this.loanDigitalPage = new ConsumerLoanDigitalPage(page);
    }
    public ConsumerLoanDigitalPageSteps enterLoanAmount(String amount) {
        loanDigitalPage.amountInput.fill(amount);
        return this;
    }

    public ConsumerLoanDigitalPageSteps enterDuration(String months) {
        loanDigitalPage.durationInput.fill(months);
        return this;
    }
    public ConsumerLoanDigitalPageSteps validateMonthlyPayment(double amount, int months, double annualRate, double delta) {
        double uiValue = getUiMonthlyPayment();

        double monthlyRate = annualRate / 12.0;
        double expected = (amount * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -months));

        Assert.assertEquals(uiValue, expected, delta,
                "Expected monthly payment " + expected + " but UI shows " + uiValue);

        return this;
    }
    public double getUiMonthlyPayment() {
        StringBuilder sb = new StringBuilder();
//        loanDigitalPage.paymentDigits.forEach(el -> sb.append(el.getText()));
        loanDigitalPage.paymentDigits.all().forEach(el -> sb.append(el.textContent()));
        return Double.parseDouble(sb.toString());
    }
}
