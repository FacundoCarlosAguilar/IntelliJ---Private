import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario.

public class OrdenInvertidoStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n < 2 || n > 5000) {
            n = scanner.nextInt();
        }

        Pila stackk = new Pila();

        // Lee `n` números enteros y los inserta en la pila.
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            stackk.push(num);
        }

        // Extrae y muestra los elementos de la pila en orden invertido.
        while (!stackk.isEmpty()) { // Mientras la pila no esté vacía...
            System.out.print(stackk.pop() + " "); // Saca y muestra el elemento superior de la pila.
        }

        scanner.close();
    }

    // Clase anidada que implementa la estructura de datos tipo pila.
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

        // Método (opcional): Muestra los elementos de la pila (para depuración).
        public void Mostrar() {
            if (isEmpty()) {
                System.out.println("La lista está vacía");
                return;
            }

            Nodo actual = this.cabeza; // Empieza en el nodo superior.
            while (actual != null) {
                System.out.println(actual.numero);
                actual = actual.siguiente;
            }
        }

        // Método: Extrae (elimina y devuelve) el elemento superior de la pila.
        public int pop() {
            if (isEmpty()) { // Si la pila está vacía, lanza una excepción.
                throw new IllegalStateException("La pila está vacía.");
            }

            int numero = this.cabeza.numero; // Obtiene el número del nodo superior.
            this.cabeza = this.cabeza.siguiente; // Actualiza la cabeza al siguiente nodo.
            return numero; // Devuelve el número del nodo extraído.
        }

        // Clase anidada para representar los nodos de la pila.
        public static class Nodo {
            private int numero; // Dato almacenado en el nodo.
            private Nodo siguiente; // Apunta al siguiente nodo en la pila.

            // Constructor: Inicializa el nodo con un número.
            public Nodo(int numero) {
                this.numero = numero; // Asigna el número proporcionado.
                this.siguiente = null; // El nodo inicialmente no tiene un sucesor.
            }
        }
    }
}
