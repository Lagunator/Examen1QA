package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParamTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "2,2,4",
                    "3,3,6",
                    "3,2,5",
                    "0,2,2",
                    "-2,-2,-4",
                    "2,7,9",
                    "0,0,0",
                    "200,20,220",
                    "-5,4,-1",
                    "9,9,18"
            }
    )
    public void verifyAdditionPar(int numberA, int numberB, int expectedResult){
        Calculator calculator = new Calculator();
        int actualResult=calculator.add(numberA,numberB);
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");
    }


}
