package org.example;
import java.util.Scanner;

public class ListaDoblementeEnlazada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaDoble lista = new ListaDoble();

        System.out.println("Ingresa la cantidad de elementos a ingresar: ");
        int cantidad = scanner.nextInt();

        System.out.println("Ingresa los elementos: ");
        for (int i = 0; i < cantidad; i++) {
            int elemento = scanner.nextInt();
            lista.InsertarPrincipio(elemento); // Agregar al principio
        }

        System.out.println("La lista de inicio a fin: ");
        lista.ImprimirPrincipio();

        System.out.println("La lista de fin a inicio: ");
        lista.ImprimirFinal();
    }

    public static class ListaDoble {

        private Nodo cabeza; // Nodo inicial
        private Nodo cola;   // Nodo final

        public ListaDoble() {
            this.cabeza = null;
            this.cola = null;
        }

        // Método: Insertar elementos al final.
        public void InsertarFinal(int numeros) {
            Nodo nuevo = new Nodo(numeros);
            if (this.cabeza == null) {
                this.cabeza = this.cola = nuevo;
            } else {
                cola.siguiente = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            }
        }

        // Método: Insertar elementos al principio.
        public void InsertarPrincipio(int numeros) {
            Nodo nuevo = new Nodo(numeros);
            if (this.cabeza == null) {
                this.cabeza = this.cola = nuevo;
            } else {
                nuevo.siguiente = cabeza;
                cabeza.anterior = nuevo;
                cabeza = nuevo;
            }
        }

        // Método: Imprimir elementos desde el principio hacia el final.
        public void ImprimirPrincipio() {
            if (this.cabeza == null) {
                System.out.println("La lista está vacía");
                return;
            }

            Nodo actual = this.cabeza;
            while (actual != null) {
                System.out.print(actual.numeros + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }

        // Método: Imprimir elementos desde el final hacia el principio.
        public void ImprimirFinal() {
            if (this.cola == null) {
                System.out.println("La lista está vacía");
                return;
            }

            Nodo actual = this.cola;
            while (actual != null) {
                System.out.print(actual.numeros + " -> ");
                actual = actual.anterior;
            }
            System.out.println("null");
        }

        // Clase anidada para representar un nodo
        public class Nodo {
            int numeros;      // Dato del nodo
            Nodo siguiente;   // Referencia al siguiente nodo
            Nodo anterior;    // Referencia al nodo anterior

            public Nodo(int numeros) {
                this.numeros = numeros;
                this.siguiente = null;
                this.anterior = null;
            }
        }
    }
}