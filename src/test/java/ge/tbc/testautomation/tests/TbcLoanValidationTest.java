package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.ConsumerLoanDigitalPageSteps;
import ge.tbc.testautomation.steps.ConsumerLoanPageSteps;
import org.testng.annotations.Test;

public class TbcLoanValidationTest extends BaseTest{


    @Test(groups = {"loan"}, description = "navigate to header")
    public void openForMeSection(){
        homePageSteps.
                openHeaderForMeSection();

    }
    @Test(groups = {"loan"}, description = "open loans link", dependsOnMethods = "openForMeSection")
    public void openLoansLink(){
        homePageSteps.openConsumerLoanPage();

    }

    @Test(groups = {"loan"}, description = "open conditions page", dependsOnMethods = "openLoansLink")
    public void navigateToLoanPage(){
        consumerLoanPageSteps.openLoanConditionsPage();

    }
    @Test(groups = {"loan"}, description = "Validate loan monthly payment is correct", dependsOnMethods = "navigateToLoanPage")
    public void testLoanCalculation() {
        loanSteps
                .enterLoanAmount("1000")
                .enterDuration("30")
                .validateMonthlyPayment(1000, 30, 0.099, 1.0);


    }
}
