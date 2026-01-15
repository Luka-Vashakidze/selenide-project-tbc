package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ConsumerLoanPage {
    public SelenideElement conditionsButton = $x("//a[@href='/ka/loans/consumer-loan/digital']/button");

}
