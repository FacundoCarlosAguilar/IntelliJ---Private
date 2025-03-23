import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int acum = 0;
        int numero = 0;
        int cant = 0;

        System.out.println("EJEMPLO DE ACUMULADOR");


        System.out.println("Ingresa la cantidad de numeros a Sumar");
        cant = scanner.nextInt();

        for (int i = 0; i < cant; i++) {

            System.out.println("Ingresa el numero: " + i);
            numero = scanner.nextInt();

            acum += numero;
        }

        System.out.println("La suma de los numeros es: " + acum);
    }
}