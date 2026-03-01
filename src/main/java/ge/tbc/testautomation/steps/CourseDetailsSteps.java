package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CourseDetailsPage;

public class CourseDetailsSteps {

    CourseDetailsPage courseDetailsPage;

    public CourseDetailsSteps(Page page) {
        this.courseDetailsPage = new CourseDetailsPage(page);
    }

    public CourseDetailsSteps clickRegistrationButton() {
        courseDetailsPage.registrationButton.click();
        return this;
    }
}
