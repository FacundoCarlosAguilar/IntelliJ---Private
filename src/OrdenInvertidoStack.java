import java.util.Scanner;
public class OrdenInvertidoStack {

    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int n = scanner.nextInt();

                // Validar que el número esté en el rango correcto
                while (n < 2 || n > 5000) {
                    n = scanner.nextInt();
                }

                Pila stackk = new Pila();

                for (int i = 0; i < n; i++) {
                    int num = scanner.nextInt();
                    stackk.push(num);
                }

                while (!stackk.isEmpty()) {
                    System.out.print(stackk.pop() + " ");
                }

                scanner.close();
            }

            public static class Pila {

                private Nodo cabeza;

                // Constructor: Inicializar.
                public Pila() {
                    this.cabeza = null;
                }

                // Método: Revisión si la PILA contiene algún elemento.
                public Boolean isEmpty() {
                    return this.cabeza == null;
                }

                // Método: Insertar un elemento en la PILA.
                public void push(int numero) {
                    Nodo nodo = new Nodo(numero);
                    nodo.siguiente = this.cabeza; // Conectar el nuevo nodo a la lista
                    this.cabeza = nodo; // Actualizar la cabeza
                }

                // Mostrar los datos que contenga la PILA.
                public void Mostrar() {
                    if (isEmpty()) {
                        System.out.println("La lista está vacía");
                        return;
                    }

                    Nodo actual = this.cabeza;
                    while (actual != null) {
                        System.out.println(actual.numero);
                        actual = actual.siguiente;
                    }
                }

                // Método: Sacar un elemento de la PILA.
                public int pop() {
                    if (isEmpty()) {
                        throw new IllegalStateException("La pila está vacía.");
                    }

                    int numero = this.cabeza.numero;
                    this.cabeza = this.cabeza.siguiente;
                    return numero;
                }

                // Clase anidada para representar los nodos de la pila "Almacenar los datos de la PILA".
                public static class Nodo {
                    private int numero;
                    private Nodo siguiente;

                    public Nodo(int numero) {
                        this.numero = numero;
                        this.siguiente = null;
                    }
                }
            }
        }