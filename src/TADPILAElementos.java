import java.util.Scanner;

public class TADPILAElementos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pila stack = new Pila();

        System.out.println("Ingresa la cantidad de elementos a ingresar en la Pila: ");
        int elementos = scanner.nextInt();

        System.out.println("Los elementos de la Pila: ");
        for (int i = 0; i < elementos; i++) {
            int x = scanner.nextInt();
            stack.push(x);
        }

        System.out.println("Los elementos ingresados en la Pila: ");
        stack.imprimir();

        scanner.close();
    }

    public static class Pila {

        private Nodo cabeza;

        // Método: Apilar un elemento en la Pila.
        public void push(int numero) {
            Nodo nuevo = new Nodo(numero);
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }

        // Método: Saber si la pila contiene algún Elemento.
        public Boolean isEmpty() {
            return this.cabeza == null;
        }

        // Método: Mostrar los elementos de la Pila.
        public void imprimir() {
            if (isEmpty()) {
                System.out.println("La pila se encuentra Vacía");
                return;
            }

            Nodo actual = this.cabeza; // Empieza en el nodo superior.
            while (actual != null) { // Recorre todos los nodos hasta el final.
                System.out.println(actual.numero); // Muestra el número del nodo actual.
                actual = actual.siguiente; // Pasa al siguiente nodo.
            }
        }

        // Clase anidada para representar los nodos de la pila.
        public static class Nodo {
            private int numero;
            private Nodo siguiente;

            // Constructor: Inicializa el nodo con un número.
            public Nodo(int numero) {
                this.numero = numero; // Asigna el número proporcionado.
                this.siguiente = null; // El nodo inicialmente no tiene un sucesor.
            }
        }
    }
}