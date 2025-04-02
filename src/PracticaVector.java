import java.util.Arrays;
import java.util.Scanner;

public class PracticaVector {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int contador = 0;

    int [] VentasMes = new int[5];
    int [] VentasSuperadas = new int[5];

        for (int i = 0; i < VentasMes.length; i++) {

            System.out.println("Ingresa la cantidad de ventas en el Día " + i + " del mes de Marzo: ");
            VentasMes[i] = scanner.nextInt();

            if (VentasMes[i] >= 2000) {
             VentasSuperadas[contador] = VentasMes[i];
             contador++;
            }
        }

        if (contador > 0) {
            for (int i = 0; i < contador; i++) {
                System.out.println("En el día" + (i + 1) + " se obtubo una venta de: " + VentasSuperadas[i]);
            }
        } else {
            System.out.println("No hubo ninguna venta que supere los $2.000");
        }
        System.out.println("La cantidad de ventas Mayor e Igual a $2.000 son: " + contador);
    }
}