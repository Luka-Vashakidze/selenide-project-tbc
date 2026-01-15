package ge.tbc.testautomation.util;

public class LoanCalculator {

    public static double calculateMonthlyPayment(double principal, double annualRate, int months) {
        double monthlyRate = annualRate / 12;
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
