package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.TechSchoolPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TechSchoolSteps {

    TechSchoolPage techSchoolPage;

    public TechSchoolSteps(Page page) {
        this.techSchoolPage = new TechSchoolPage(page);
    }

    public int getNumberOfCourses() {
        assertThat(techSchoolPage.courseCards.first()).isVisible();
        return techSchoolPage.courseCards.count();
    }

    public TechSchoolSteps clickCourseByIndex(int index) {
        techSchoolPage.courseLinkByIndex(index).scrollIntoViewIfNeeded();
        techSchoolPage.courseLinkByIndex(index).click();
        return this;
    }
}