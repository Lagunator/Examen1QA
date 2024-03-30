package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorMultTest {
    Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void verifyAdditionPar(){
        int actualResult=calculator.mult(2,2);
        int expectedResult=4;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la mult es incorrecta");
    }

    @Test
    public void verifyAdditionImpar(){
        int actualResult=calculator.mult(3,3);
        int expectedResult=9;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la mult es incorrecta");
    }

    @Test
    public void verifyAdditionImparPar(){
        int actualResult=calculator.mult(2,3);
        int expectedResult=6;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la mult es incorrecta");
    }
}
