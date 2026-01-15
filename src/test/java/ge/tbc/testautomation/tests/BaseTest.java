package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.TBC_BASE_URL;

public class BaseTest {
    HomePageSteps homePageSteps;
    LocationPageSteps locationPageSteps;
    OffersSteps offersSteps ;
    TechSchoolSteps techSteps ;
    CourseDetailsSteps detailsSteps;
    ConsumerLoanDigitalPageSteps loanSteps = new ConsumerLoanDigitalPageSteps();
    ConsumerLoanPageSteps consumerLoanPageSteps = new ConsumerLoanPageSteps();


    @BeforeClass
    @Parameters({"browserSize"})
    public void setUp(@Optional("1920x1080") String browserSize) {
        Configuration.browserSize = browserSize;
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.browserSize = "1920x1080";
        open(TBC_BASE_URL);
        offersSteps = new OffersSteps();
        homePageSteps = new HomePageSteps();
        locationPageSteps = new LocationPageSteps();
        techSteps = new TechSchoolSteps();
        detailsSteps = new CourseDetailsSteps();

    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
