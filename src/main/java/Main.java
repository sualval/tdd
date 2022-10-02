import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static double percent = 15;
    static double creditAmount = 100_000;
    static int month = 12;
    int dayInYear = 365;
    int dayInMonth = 31;
    double monthlyAmount = creditAmount / month;
    Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Enter credit amount:");
        creditAmount = main.ParametersForCalculation();
        System.out.println("Enter number of months:");
        month = main.ParametersForCalculation();
        System.out.println(Arrays.toString(main.resultCreditCalculator(creditAmount, month)));
    }

    public Integer ParametersForCalculation() {
        while (true) {
            try {
                scanner = new Scanner(System.in);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("NumberFormatException");
            }
        }
    }

    public double[] resultCreditCalculator(double creditAmount, int month) {
        double overpaymentCalculation = 0;
        double calculatingTotalRefund;
        double monthlyPaymentCalculation;
        double outstandingBalance = creditAmount;
        for (int i = 0; i < month; i++) {
            overpaymentCalculation += ((percent / 100 / dayInYear * dayInMonth) * outstandingBalance);
            outstandingBalance -= monthlyAmount;
        }
        calculatingTotalRefund = overpaymentCalculation + creditAmount;
        monthlyPaymentCalculation = calculatingTotalRefund / month;
        return new double[]{overpaymentCalculation, calculatingTotalRefund, monthlyPaymentCalculation};
    }
}
