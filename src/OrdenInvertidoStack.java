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

        // Lee `n` números enteros y los inserta en la pila.
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            stackk.push(num);
        }

        // Muestra los elementos en el orden original antes de hacer el pop
        System.out.println("Elementos en orden original:");
        stackk.Mostrar();  // Imprime los elementos sin eliminarlos

        // Extrae y muestra los elementos de la pila en orden invertido.
        System.out.println("\nElementos en orden invertido (LIFO):");
        while (!stackk.isEmpty()) {
            System.out.print(stackk.pop() + " ");  // Imprime y elimina los elementos de la pila
        }

        scanner.close();
    }

    public static class Pila {

        private Nodo cabeza;

        // Constructor: Inicializa la pila como vacía.
        public Pila() {
            this.cabeza = null;
        }

        // Método: Verifica si la pila está vacía.
        public Boolean isEmpty() {
            return this.cabeza == null;
        }

        // Método: Inserta un elemento en la pila.
        public void push(int numero) {
            Nodo nodo = new Nodo(numero);
            nodo.siguiente = this.cabeza;
            this.cabeza = nodo;
        }

        // Método: Muestra los elementos de la pila
        public void Mostrar() {
            if (isEmpty()) {
                System.out.println("La lista está vacía");
                return;
            }

            Nodo actual = this.cabeza; // Empieza en el nodo superior.
            while (actual != null) { // Recorre todos los nodos hasta el final.
                System.out.println(actual.numero); // Muestra el número del nodo actual.
                actual = actual.siguiente; // Pasa al siguiente nodo.
            }
        }

        // Método: Extrae (elimina y devuelve) el elemento superior de la pila.
        public int pop() {
            if (isEmpty()) {
                System.out.println("La pila esta Vacía");
            }

            int numero = this.cabeza.numero;
            this.cabeza = this.cabeza.siguiente;
            return numero;
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
