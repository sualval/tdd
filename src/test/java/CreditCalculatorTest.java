import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCalculatorTest {
    private final double creditAmount = 100000;
    private final int month = 12;
    double overpaymentCalculation = 0;
    double calculatingTotalRefund;
    double monthlyPaymentCalculation;
    double[] expected;
     Main main = new Main();

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
        expected = new double[]{overpaymentCalculation, calculatingTotalRefund, monthlyPaymentCalculation};

    }

    @Test
    void TestLengthArray() {

        assertEquals(3, main.resultCreditCalculator(creditAmount, month).length);
    }

    @Test
    void TestResultCreditCalculator() {
        assertArrayEquals(expected, main.resultCreditCalculator(creditAmount, month), 1e-2);
    }

    @Test
    void TestParametersForCalculation() {
        System.setIn(new ByteArrayInputStream("200000".getBytes()));
        assertEquals(200000, main.ParametersForCalculation());

    }
}
