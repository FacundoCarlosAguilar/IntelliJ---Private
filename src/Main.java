import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Suma sumaNumero = new Suma();

        System.out.println("SUMA DE NUMEROS");
        System.out.println(" ");

        sumaNumero.Suma(scanner);
    }
}