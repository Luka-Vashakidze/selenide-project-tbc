package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ConsumerLoanDigitalPage {

        public SelenideElement amountInput = $x("//input[@type='number' and @min='200' and @max='80000']");

        public SelenideElement durationInput = $x("//input[@type='number' and @min='3' and @max='48']");

        public ElementsCollection paymentDigits = $$x("//div[contains(@class,'tbcx-pw-calculated-info__number--new')]/span[not(contains(text(),'₾'))]");


}
