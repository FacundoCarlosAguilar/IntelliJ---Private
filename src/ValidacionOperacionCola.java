import java.util.Scanner;

public class ValidacionOperacionCola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita la cantidad de operaciones a realizar
        int n = scanner.nextInt();

        // Valida que el número esté en el rango permitido
        while (n < 1 || n > 1000) {
            System.out.println("Ingresar un valor dentro de 1 y 1000.");
            n = scanner.nextInt();
        }

        Cola cola = new Cola(); // Se crea una nueva cola

        // Bucle que ejecuta cada operación ingresada por el usuario
        for (int i = 0; i < n; i++) {
            String operacion = scanner.next();

            // Analiza la operación ingresada por el usuario
            switch (operacion) {

                case "PUSH":
                    // Intenta leer un valor numérico después del comando PUSH
                    // "PUSH "VALOR NUMÉRICO", en caso contrario "PUSH hola" dejaría un error".
                    String value = scanner.next(); // Lee el siguiente valor ingresado

                    try {
                        int x = Integer.parseInt(value); // Convierte el valor a entero, el "PUSH 700" solo toma el número.

                        // Verificamos que el "700" se encuentre en el rango.
                        if (x >= -1000 && x <= 1000) {
                            cola.Enqueue(x); // Si es válido, se agrega al final de la cola
                        }

                    } catch (NumberFormatException e) {
                        // Si el valor ingresado no es un número, lo ignora sin mostrar error
                        // Eso quiere decir que no se detendrá el programa.
                    }
                    break;

                case "TOP":
                    // Muestra el primer valor de la cola sin haber sido eliminado.
                    if (!cola.isEmpty()) { // Verificamos que la cola no se encuentre vacía.
                        System.out.println(cola.Top()); // Si la cola no está vacía, muestra el valor superior de la cola.
                    } else {
                        System.out.println("EMPTY"); // Si está vacía, muestra "EMPTY"
                    }
                    break;

                case "POP":
                    // Elimina el primer elemento de la cola
                    if (!cola.isEmpty()) { // Verificamos que la cola no se encuentre vacía.
                        cola.Dequeue(); // Elimina el primer elemento si existe
                    } else {
                        System.out.println("No"); // Muestra "No" si la cola está vacía
                    }
                    break;

                case "EMPTY":
                    // Verifica si la cola está vacía y lo informa
                    System.out.println(cola.isEmpty() ? "Si" : "No");
                    // Muestra "Si" si está vacía, o "No" si contiene elementos
                    break;

                case "SIZE":
                    // Muestra cuántos elementos tiene actualmente la cola
                    System.out.println(cola.size()); // Imprimo la cantidad de elementos en la cola.
                    break;
            }
        scanner.close();
        }
    }

    // Clase que representa la estructura de una Cola
    public static class Cola {

        // Punteros "Elementos" de la Cola.
        private Nodo Frente;
        private Nodo Final;

        // Constructor: Inicializo los punteros "elementos" a null.
        public Cola() {
            this.Frente = null;
            this.Final = null;
        }

        // Método IsEmpty: Verificación para saber si la cola se encuentra con elementos o sin Elementos.
        public boolean isEmpty() {
            return this.Frente == null;
        }

        // Método Enqueue: Agrear un elemento al final de la Cola.
        public void Enqueue(int numero) {
            Nodo nuevo = new Nodo(numero); //Creo un nuevo nodo con variedad de tipo int.

            // Primero verifico que la pila se encuentra vacía o tiene elementos.
            if (this.Final == null) {
                // Si está vacía, el nuevo nodo es tanto el frente como el final de la Cola.
                this.Frente = this.Final = nuevo;
            } else {
                // Si ya hay elementos, se agrega al final de la Cola.
                this.Final.siguiente = nuevo;
                this.Final = nuevo; // Ahora el nuevo es el ultimo de la Cola.
            }
        }

        // Método Dequeue: Elimina el ultimo valor de la cola y retorna su valor Eliminado.
        public int Dequeue() {
            if (isEmpty()) { //Primero verifico que la cola contenga algún Elemento.
                return -1;
            }
            // En caso contrario debo pasar el puntero al siguiente elemento para que el Garbage Collected lo elimine.
            int numero = this.Frente.numero; // Considero el elemento numérico superior y lo traslado a la variable int.
            this.Frente = this.Frente.siguiente; // Ahora debo mover el puntero al siguiente elemento numérico que esté al frente.

            //Verificación si ahí aún más elementos en la Cola
            if (this.Frente == null) {
                this.Final = null; // En caso de que no ahí más elemento en la parte superior e inferior se retorna el número eliminado por el Garbage Collected.
            }
            return numero; // Retornar el elemento eliminado.
        }

        // Método Top: Mostrar el elemento en la parte superior sin Eliminarlo.
        public int Top() {
            if (isEmpty()) { //Primero verifico que la cola contenga algún Elemento.
                return -1;
            }
            return this.Frente.numero; // En caso de contener algún elemento, debo retornar el valor numérico en la parte superior.
        }

        // Función Size: Imprimir la cantidad elementos que contiene la Cola.
        public int size() {
            int size = 0; // Creo la variable Size e inicializo en "0".

            Nodo actual = Frente; // Creo un nodo "actual" el cual estará en la parte Superior.
            while (actual != null) { // Ahora recorro toda la cola hasta llegar a null, eso quiere decir que recorro hasta ver el siguiente elemento es Null.
                size++; // Mientras recorro voy contando la cantidad de elementos que voy Pasando.
                actual = actual.siguiente; // Actual hira pasando de elemento en elemento de la cola hasta llegar a la parte inferior de la Cola.
            }
            return size; // Luego de llegar al null, voy a retornar la cantidad de elementos los cuales ha pasado hasta llegar a la parte inferior de la Cola.
        }

        // Clase interna que representa un Nodo de la cola
        public static class Nodo {
            private int numero;        // Valor del nodo
            private Nodo siguiente;    // Apunta al siguiente nodo

            public Nodo(int numero) {
                this.numero = numero;
                this.siguiente = null;
            }
        }
    }
}