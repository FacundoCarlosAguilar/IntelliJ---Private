import java.util.Objects;
import java.util.Scanner;


public class ImplementacionCola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de elementos a Ingresar: ");
        int n = scanner.nextInt();

        Cola cola = new Cola();

        // Insertar los elementos en la cola
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            cola.Enqueue(x); // Agregar elementos a la cola
        }

        System.out.println("Los elementos en la cola: ");
        cola.Imprimir(); // Mostrar los elementos de la cola

        // Realizar una operación de deque (eliminar el primer elemento)
        System.out.println("Elemento eliminado de la cola: " + cola.Dequeue());
        System.out.println("Elemento eliminado de la cola: " + cola.Dequeue());

        // Mostrar los elementos después de la eliminación
        System.out.println("Los elementos en la cola después de un dequeue /Desencolar");
        cola.Imprimir();

        scanner.close();
    }

    public static class Cola {

        //Creación del Nodo Frente
        //Creación del Nodo Final
        private Nodo Frente;
        private Nodo Final;

        //Constructor: Inicializamos el frente y final de la pila como Vacío.
        public Cola() {
            this.Frente = null;
            this.Final = null;
        }

        //Método isEmpty: Para saber si la cola contiene algún elemento.
        public Boolean isEmpty() {
            return Frente == null;
        }

        //Método Enqueue: Encolar elementos en la cola.
        public void Enqueue(int numero) {
            Nodo nuevo = new Nodo(numero);

            //Primero me pregunto si el final está vacío
            if (this.Final == null) {
                //Agrego un elemento en la parte del frente de la cola.
                //Agrego un elemento en el final de la Cola.
                this.Frente = nuevo;
                this.Final = nuevo;

            } else {
                //Enlazo el último nodo al nuevo Nodo.
                //Actualizo el nuevo final de la Cola.
                this.Final.siguiente = nuevo;
                this.Final = nuevo;
            }
        }

        //Función Extract: Sacar el ultímo elemento de la Cola.
        public int Dequeue() {
            if (isEmpty()) {
                System.out.println("La cola se encuentra Vacía");
                return -1;
            }
            int numero = this.Frente.numero; //El primer nodo entero lo paso a un variable entera.
            this.Frente = this.Frente.siguiente; //El primero nodo de la cola es ahora el siguiente nodo.

            //Indicación de que la cola se quedo sin nodos.
            if (this.Frente == null) {
                this.Final = null;
            }
            return numero;  // Devuelvo el número Eliminado.
        }

        //Método Imprimir: Utilizado para mostrar los elementos en la Cola.
        public void Imprimir() {
            if (isEmpty()) {
                System.out.println("La cola se encuentra Vacía");
                return;
            }

            Nodo actual = this.Frente;
            while (actual != null) {
                System.out.print(actual.numero);
                actual = actual.siguiente;
            }
            System.out.println();
        }

        //Clase Anidada para mostrar los nodos en la Cola.
        public static class Nodo {
            public Nodo siguiente;
            private int numero;
            private Nodo Siguiente;

            public Nodo(int numero) {
                this.numero = numero;
                this.Siguiente = null;
            }
        }
    }
}