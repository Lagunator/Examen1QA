package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void verifyAdditionPar(){
        int actualResult=calculator.add(2,2);
        int expectedResult=4;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");
    }
    @Test
    public void verifyAdditionImpar(){
        int actualResult=calculator.add(3,3);
        int expectedResult=6;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");
    }

    @Test
    public void verifyAdditionImparPar(){
        int actualResult=calculator.add(2,3);
        int expectedResult=5;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");
    }
}
