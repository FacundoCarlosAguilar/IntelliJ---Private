import java.util.Scanner;

public class ImplementacionPila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la entrada de n
        int n = scanner.nextInt();

        while (n < 1 || n > 100000) {
            System.out.println("Por favor, ingrese un número entre 1 y 100000.");
            n = scanner.nextInt();
        }

        Pila stack = new Pila();

        for (int i = 0; i < n; i++) {
            String operacion = scanner.next();

            switch (operacion) {
                case "PUSH":
                    int x = scanner.nextInt();
                    if (x >= -1000 && x <= 1000) {
                        stack.push(x);
                    }
                    break;
                case "TOP":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.top());
                    } else {
                        System.out.println("Su pila está vacía.");
                    }
                    break;
                case "POP":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        System.out.println("Su pila está vacía.");
                    }
                    break;
                case "EMPTY":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "SIZE":
                    System.out.println(stack.size());
                    break;
            }
        }
        scanner.close();
    }

    public static class Pila {

        private Nodo cabeza;

        public Pila() {
            cabeza = null;
        }

        // Corregido el nombre del método a isEmpty
        public Boolean isEmpty() {
            return this.cabeza == null;
        }

        public void push(int numero) {
            Nodo nuevo = new Nodo(numero);
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }

        public int top() {
            if (isEmpty()) {
                throw new IllegalStateException("La pila está vacía");
            }
            return this.cabeza.numero;
        }

        public void pop() {
            if (isEmpty()) {
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