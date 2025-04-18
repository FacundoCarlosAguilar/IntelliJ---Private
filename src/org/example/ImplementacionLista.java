package org.example;

import java.util.Scanner;

class ImplementacionLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de personas a agregar: ");
        int n = scanner.nextInt();

        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingresa los nombres:");
        for (int i = 0; i < n; i++) {
            String x = scanner.next();
            lista.agregarFinal(x);
        }

        System.out.println("Los nombres ingresados en la lista: ");
        lista.imprimir();
    }

    public static class ListaEnlazada {
        private Nodo cabeza; // Referencia al primer nodo

        // Constructor: Inicializa la lista como vacía
        public ListaEnlazada() {
            this.cabeza = null;
        }

        /**
         * Agrega un nuevo nodo al final de la lista.
         * @param nombres El nombre a agregar.
         */
        public void agregarFinal(String nombres) {
            Nodo nuevo = new Nodo(nombres);

            if (this.cabeza == null) {
                this.cabeza = nuevo; // Si la lista está vacía, el nuevo nodo es la cabeza
            } else {
                Nodo temp = this.cabeza;
                while (temp.siguiente != null) {
                    temp = temp.siguiente; // Avanzar al siguiente nodo
                }
                temp.siguiente = nuevo; // Agregar el nuevo nodo al final
            }
        }

        /**
         * Imprime todos los elementos de la lista.
         */
        public void imprimir() {
            if (this.cabeza == null) {
                System.out.println("No hay nodos en la lista.");
                return;
            }

            Nodo temp = this.cabeza;
            while (temp != null) {
                System.out.print(temp.nombres + " -> ");
                temp = temp.siguiente;
            }
            System.out.println("NULL");
        }

        // Clase anidada para representar un nodo
        public class Nodo {
            String nombres; // Dato del nodo
            Nodo siguiente; // Referencia al siguiente nodo

            /**
             * Constructor: Inicializa un nodo con un nombre.
             * @param nombres El nombre a almacenar en el nodo.
             */
            public Nodo(String nombres) {
                this.nombres = nombres;
                this.siguiente = null;
            }
        }
    }
}