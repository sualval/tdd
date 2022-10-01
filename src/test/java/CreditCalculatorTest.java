import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCalculatorTest {
    private final double creditAmount = 100000;
    private final int month = 12;
    double overpaymentCalculation = 0;
    double calculatingTotalRefund;
    double monthlyPaymentCalculation;

    @BeforeEach
    void createNewClass() {
        double outstandingBalance = creditAmount;
        int dayInMonth = 31;
        int dayInYear = 365;
        double percent = 15;
        for (int i = 0; i < month; i++) {
            overpaymentCalculation += ((percent / 100 / dayInYear * dayInMonth) * outstandingBalance);
            double monthlyAmount = creditAmount / month;
            outstandingBalance -= monthlyAmount;
        }
        calculatingTotalRefund = overpaymentCalculation + creditAmount;
        monthlyPaymentCalculation = calculatingTotalRefund / month;
    }

    @Test
    void TestMonthlyPaymentCalculation() {
        double extend = monthlyPaymentCalculation;

        assertEquals(extend, Main.monthlyPaymentCalculation());

    }

    @Test
    void TestCalculatingTotalRefund() {
        double extend = calculatingTotalRefund;
        assertEquals(extend, Main.calculatingTotalRefund(creditAmount));
    }

    @Test
    void TestOverpaymentCalculation() {

        double expected = overpaymentCalculation;
        assertEquals(expected, Main.overpaymentCalculation(creditAmount, month));
    }

}
