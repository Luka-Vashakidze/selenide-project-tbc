package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.ConsumerLoanPage;
import ge.tbc.testautomation.pages.ConsumerLoanDigitalPage;
import ge.tbc.testautomation.pages.HomePage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class ConsumerLoanDigitalPageSteps    {
    ConsumerLoanDigitalPage loanDigitalPage = new ConsumerLoanDigitalPage();

    public ConsumerLoanDigitalPageSteps enterLoanAmount(String amount) {
        loanDigitalPage.amountInput.shouldBe(visible).clear();
        loanDigitalPage.amountInput.setValue(amount);
        return this;
    }

    public ConsumerLoanDigitalPageSteps enterDuration(String months) {
        loanDigitalPage.durationInput.shouldBe(visible).clear();
        loanDigitalPage.durationInput.setValue(months);
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
        loanDigitalPage.paymentDigits.forEach(el -> sb.append(el.getText()));
        return Double.parseDouble(sb.toString());
    }
}
