package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

public class TbcLoanValidationTest extends BaseTest{

    @Test(groups = {"loan"}, description = "Navigate to consumer loan page")
    public void navigateToConsumerLoanPage(){
        homePageSteps.openConsumerLoanPage();
    }

    @Test(groups = {"loan"}, description = "Open loan conditions page", dependsOnMethods = "navigateToConsumerLoanPage")
    public void navigateToLoanConditionsPage(){
        consumerLoanPageSteps.openLoanConditionsPage();
    }

    @Test(groups = {"loan"}, description = "Validate loan monthly payment is correct", dependsOnMethods = "navigateToLoanConditionsPage")
    public void testLoanCalculation() {
        loanSteps
                .enterLoanAmount("1000")
                .enterDuration("30")
                .validateMonthlyPayment(1000, 30, 0.099, 1.0);

    }
}
