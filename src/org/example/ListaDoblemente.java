package org.example;
import java.util.Scanner;

class EjmeploPlaylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaDoblemente lista = new ListaDoblemente();

        System.out.println("Ingresa la cantidad de elementos para ingresar en la Lista: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            lista.insertarAlInicio(x);
        }

        System.out.println("La lista queda de la siguiente Manera: ");
        lista.imprimirDesdeInicio();

        System.out.println(" ");

        System.out.println("'¿Quieres insertar un elemento al final o al inicio: S/Final, N/Principio");
        String opcion = scanner.next();

        if (opcion.equals("S")) {
            System.out.println("Ingresa el Elemento: ");
            int p = scanner.nextInt();

            System.out.println("Insertar en el Principio: ");
            lista.insertarAlInicio(p);
        } else {
            if (opcion.equals("N")) {
                System.out.println("Ingresa el Elemento: ");
                int p = scanner.nextInt();

                System.out.println("Insertar en el Final: ");
                lista.insertarAlFinal(p);
            }
        }

        System.out.println("La lista queda de la siguiente Manera: ");
        lista.imprimirDesdeInicio();
    }
}

public class ListaDoblemente  {

    // Nodo de la lista
    class Nodo {
        int dato;
        Nodo anterior;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
        }
    }

    Nodo cabeza = null;
    Nodo cola = null;

    // Insertar al inicio
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

    // Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cola == null) {
            cabeza = cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    // Eliminar un nodo por valor
    public void eliminar(int dato) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.dato == dato) {
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    if (cabeza != null) cabeza.anterior = null;
                } else if (actual == cola) {
                    cola = cola.anterior;
                    if (cola != null) cola.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Elemento no encontrado.");
    }

    // Imprimir desde el inicio
    public void imprimirDesdeInicio() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Imprimir desde el final
    public void imprimirDesdeFinal() {
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}