package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.ConsumerLoanPage;

import static com.codeborne.selenide.Condition.visible;

public class ConsumerLoanPageSteps {
  ConsumerLoanPage loanPage = new ConsumerLoanPage();

    public ConsumerLoanPageSteps openLoanConditionsPage() {
        loanPage.conditionsButton.shouldBe(visible).click();
        return this;
    }


}
