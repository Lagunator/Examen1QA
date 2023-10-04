package Ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioCalculatorTest {
    private SalarioCalculator salarioCalculator = new SalarioCalculator();

    @ParameterizedTest
    @CsvSource({
            "2000, 0.0",
            "2000.01, 5.0",
            "1999.99, 0.0",
            "4000, 5.0",
            "4000.01, 15.0",
            "3999.99, 5.0",
            "1500, 0.0",
            "4500, 15.0",
            "-500, 0.0"
    })
    public void shouldCalculateDeductionCorrectly(double wage, double expectedDeduction) {
        if (wage < 0) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> salarioCalculator.determineDeduction(wage));
        } else {
            double actualDeduction = salarioCalculator.determineDeduction(wage);
            Assertions.assertEquals(expectedDeduction, actualDeduction, "Tuvimos un error en nuestra deduccion perdon!");
        }
    }
}
