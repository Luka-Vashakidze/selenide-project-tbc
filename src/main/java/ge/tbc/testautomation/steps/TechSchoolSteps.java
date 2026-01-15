package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.TechSchoolPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;

public class TechSchoolSteps {

    TechSchoolPage techSchoolPage = new TechSchoolPage();

    public int getNumberOfCourses() {
        return techSchoolPage.courseCards.shouldHave(sizeGreaterThan(0)).size();
    }

    public TechSchoolSteps clickCourseByIndex(int index) {
        techSchoolPage.courseLinkByIndex(index)
                .scrollTo()
                .shouldBe(visible)
                .click();
        return this;
    }
}