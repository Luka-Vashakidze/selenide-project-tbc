package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static ge.tbc.testautomation.data.Constants.TBC_BASE_URL;

public class BaseTest {
    protected Playwright playwright;
    protected BrowserContext context;
    protected Page page;
    protected Browser browser;
    protected int viewportWidth;
    protected int viewportHeight;

    HomePageSteps homePageSteps;
    LocationPageSteps locationPageSteps;
    OffersSteps offersSteps;
    TechSchoolSteps techSteps;
    CourseDetailsSteps detailsSteps;
    ConsumerLoanDigitalPageSteps loanSteps;
    public ConsumerLoanPageSteps consumerLoanPageSteps;

    @BeforeClass
    @Parameters({"browserSize", "browserType"})
    public void setUp(@Optional("1920x1080") String browserSize, @Optional("chromium") String browserType) {
        String[] dimensions = browserSize.split("x");
        viewportWidth = Integer.parseInt(dimensions[0]);
        viewportHeight = Integer.parseInt(dimensions[1]);

        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);

        browser = switch (browserType.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(launchOptions);
            case "webkit" -> playwright.webkit().launch(launchOptions);
            default -> playwright.chromium().launch(launchOptions);
        };

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(viewportWidth, viewportHeight));
        page = context.newPage();
        page.navigate(TBC_BASE_URL);

        homePageSteps = new HomePageSteps(page);
        locationPageSteps = new LocationPageSteps(page);
        offersSteps = new OffersSteps(page);
        techSteps = new TechSchoolSteps(page);
        detailsSteps = new CourseDetailsSteps(page);
        loanSteps = new ConsumerLoanDigitalPageSteps(page);
        consumerLoanPageSteps = new ConsumerLoanPageSteps(page);
    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
