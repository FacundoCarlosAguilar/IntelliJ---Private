import java.util.Scanner;
public class Suma {

    int numero;
    int acumulador;

    public Suma() {

        this.numero = numero;
        this.acumulador = acumulador;

    }

    public void Suma(Scanner scanner) {
    int acum;
    int sumado = 0;

        System.out.println("Ingresa la cantidad de numeros a Sumar: ");
        acum = scanner.nextInt();

        for (int i = 0; i < acum; i++) {

            System.out.println("Ingresa el Numero: " + i);
            this.numero = scanner.nextInt();
            sumado += this.numero;

        }
        System.out.println("La suma de los Numeros es: " + sumado);
    }
}
