package badPractice;

public class Calc {

    public int add(int a, int b){
        return a+b;
    }

    public static void main(String[]args){
        // Mala practica
        Calc calc = new Calc();
        if (calc.add(5,5) == 10)
            System.out.println("PASSED");
        else
            System.out.println("FAILED");
    }
}

