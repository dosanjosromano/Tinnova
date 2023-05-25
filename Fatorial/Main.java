
import java.util.Scanner;

public class Principal {

    public static void main (String[] args) {
        Fatorial numeroFatorial = new Fatorial();
        numeroFatorial.calculaFatorial(10);
        System.out.println(numeroFatorial.getFatorial());
    }

}