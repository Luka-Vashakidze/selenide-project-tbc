package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.CourseDetailsPage;
import static com.codeborne.selenide.Condition.visible;

public class CourseDetailsSteps {

    CourseDetailsPage courseDetailsPage = new CourseDetailsPage();

    public CourseDetailsSteps clickRegistrationButton() {
        courseDetailsPage.registrationButton.shouldBe(visible).click();
        return this;
    }
}
