package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CourseDetailsPage {

    public SelenideElement registrationButton = $x("//div[contains(@class,'button-wrapper')]//a[contains(@href,'forms')]");
}
