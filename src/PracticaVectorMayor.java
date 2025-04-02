import java.util.Scanner;

public class PracticaVectorMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] Vector = new int[5];
        int maximo = 0;

        System.out.println("Ingresa los datos del vector: ");

        for (int i = 0; i < Vector.length; i++) {
            System.out.println("Ingresa el Valor: " + (i + 1));
            Vector[i] = scanner.nextInt();

            if (Vector[i] > maximo) {
                maximo = Vector[i];
            }
        }
        System.out.println("El numero Mayor: " + maximo);
    }
}