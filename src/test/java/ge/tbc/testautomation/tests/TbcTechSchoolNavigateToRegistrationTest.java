package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class TbcTechSchoolNavigateToRegistrationTest extends BaseTest {

    @Test(groups = {"techschool"}, description = "Hover TBC menu and click Tech School")
    public void openTbcAndTechSchool() {
        homePageSteps
                .openTbcMenu()
                .openTechSchool();
    }

    @Test(groups = {"techschool"}, description = "Validate courses exist and select  first one", dependsOnMethods = "openTbcAndTechSchool")
    public void validateCoursesAndSelect() {
        int courseCount = techSteps.getNumberOfCourses();
        System.out.println("Total available courses: " + courseCount);
        techSteps.clickCourseByIndex(1);
    }

    @Test(groups = {"techschool"}, description = "Click registration button on details page", dependsOnMethods = "validateCoursesAndSelect")
    public void clickRegistration() {
        detailsSteps.clickRegistrationButton();
    }
}