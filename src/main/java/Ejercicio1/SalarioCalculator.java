package Ejercicio1;

public class SalarioCalculator {
    private static final int BASICWAGE = 2000;

    public double determineDeduction(double wageAmount) {
        if (wageAmount <= 0) {
            throw new IllegalArgumentException("Salario Invalido");
        }

        if (wageAmount <= BASICWAGE) {
            return 0.0;
        } else if (wageAmount > BASICWAGE && wageAmount <= 2 * BASICWAGE) {
            return 5.0;
        } else {
            return 15.0;
        }
    }
}
