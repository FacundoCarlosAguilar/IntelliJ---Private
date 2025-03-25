import java.util.Scanner;

public class ImplementacionPila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        while (n < 1 || n > 100000) {
            n = scanner.nextInt();
        }

        Pila stack = new Pila();

        /* PREGUNTAR AL PROFESOR */

        scanner.close();
    }

    public static class Pila {

        private Nodo cabeza;

        public Pila() {
            cabeza = null;
        }

        public Boolean isEmptry() {
            return this.cabeza == null;
        }

        public void push(int numero) {
            Nodo nuevo = new Nodo(numero);
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }

        public int top() {
            if (isEmptry()) {
                throw new IllegalStateException("La pila está vacía");
            }
            return this.cabeza.numero;
        }

        public void pop() {
            if (isEmptry()) {
                throw new IllegalStateException("La pila está vacía");
            }
            this.cabeza = this.cabeza.siguiente;
        }

        public int size() {
            int size = 0;
            Nodo actual = this.cabeza;

            while (actual != null) {
                size++;
                actual = actual.siguiente;
            }
            return size;
        }

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