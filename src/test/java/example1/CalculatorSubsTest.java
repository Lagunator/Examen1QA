package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class CalculatorSubsTest {
    Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void verifySubsPar() throws Exception {
        int actualResult=calculator.subs(4,2);
        int expectedResult=2;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la resta es incorrecta");
    }

    @Test
    @Timeout(value = 2)
    public void verifySubsTimePar() throws Exception {
        int actualResult=calculator.subs(4,2);
        int expectedResult=2;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la resta es incorrecta");
    }
}
