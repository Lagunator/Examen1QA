package example2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NotaTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "-1,nota incorrecta-ingresa nuevamente",
                    "0,Necesitas Mejorar: 0",
                    "1,Necesitas Mejorar: 1",
                    "34,Necesitas Mejorar: 34",
                    "35,Necesitas Mejorar: 35",
                    "36,Necesitas Mejorar: 36",
                    "69,Necesitas Mejorar: 69",
                    "70,Necesitas Mejorar: 70",
                    "71, Bien: 71",
                    "72, Bien: 72",
                    "74, Bien: 74",
                    "75, Bien: 75",
                    "76, Bien: 76",
                    "79, Bien: 79",
                    "80, Bien: 80",
                    "81, Muy Bien: 81",
                    "82, Muy Bien: 82",
                    "85, Muy Bien: 85",
                    "86, Muy Bien: 86",
                    "87, Muy Bien: 87",
                    "89, Muy Bien: 89",
                    "90, Muy Bien: 90",
                    "91, Excelente: 91",
                    "92, Excelente: 92",
                    "94, Excelente: 94",
                    "95, Excelente: 95",
                    "96, Excelente: 96",
                    "99, Excelente: 99",
                    "100, Excelente: 100",
                    "101,nota incorrecta-ingresa nuevamente"

            }
    )
    public void verifyGetMessage(int notaValue, String expectedResult) {
        Nota nota = new Nota();
        String actualResult = nota.getMessage(notaValue);
        Assertions.assertEquals(expectedResult, actualResult, "ERROR!el mensaje es incorrecto");
    }
}
