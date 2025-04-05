import java.util.Scanner;

public class ValidacionOperacionCola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n < 1 || n > 1000) return;

        Cola cola = new Cola();

        for (int i = 0; i < n; i++) {
            String operacion = scanner.next();

            switch (operacion) {
                case "PUSH":
                    String value = scanner.next();
                    try {
                        int x = Integer.parseInt(value);
                        if (x >= -1000 && x <= 1000) {
                            cola.Enqueue(x);
                        }
                    } catch (NumberFormatException e) {
                        // Ignoramos valores no numéricos
                    }
                    break;
                case "TOP":
                    if (!cola.isEmpty()) {
                        System.out.println(cola.Top());
                    } else {
                        System.out.println("EMPTY");
                    }
                    break;
                case "POP":
                    if (!cola.isEmpty()) {
                        cola.Dequeue();
                    } else {
                        System.out.println("EMPTY");
                    }
                    break;
                case "EMPTY":
                    System.out.println(cola.isEmpty() ? "Si" : "No");
                    break;
                case "SIZE":
                    System.out.println(cola.size());
                    break;
            }
        }
        scanner.close();
    }

    public static class Cola {

        private Nodo Frente;
        private Nodo Final;

        public Cola() {
            this.Frente = null;
            this.Final = null;
        }

        public boolean isEmpty() {
            return Frente == null;
        }

        public void Enqueue(int numero) {
            Nodo nuevo = new Nodo(numero);
            if (Final == null) {
                Frente = Final = nuevo;
            } else {
                Final.siguiente = nuevo;
                Final = nuevo;
            }
        }

        public int Dequeue() {
            if (isEmpty()) {
                return -1;
            }
            int numero = Frente.numero;
            Frente = Frente.siguiente;
            if (Frente == null) {
                Final = null;
            }
            return numero;
        }

        public int Top() {
            if (isEmpty()) {
                return -1;
            }
            return Frente.numero;
        }

        public int size() {
            int size = 0;
            Nodo actual = Frente;
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