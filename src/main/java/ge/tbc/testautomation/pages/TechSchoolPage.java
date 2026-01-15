package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TechSchoolPage {

    public ElementsCollection courseCards =
            $$x("//div[contains(@class,'tbcx-pw-carousel__card')]");

    public SelenideElement courseLinkByIndex(int index) {
        return $x("(//div[contains(@class,'tbcx-pw-carousel__card')]//a)[" + index + "]");
    }
}
