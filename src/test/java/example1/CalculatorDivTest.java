package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorDivTest {
    Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void verifyDivPar() throws Exception {
        int actualResult=calculator.div(4,2);
        int expectedResult=2;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la mult es incorrecta");
    }

    @Test
    public void verifyDivZero() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            calculator.div(4, 0);
        });
    }

}
