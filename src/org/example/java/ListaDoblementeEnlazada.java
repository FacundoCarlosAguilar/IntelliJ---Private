package org.example.java;
import java.util.Scanner;

public class ListaDoblementeEnlazada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario un número entero que indique la cantidad de operaciones.
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea residual después del entero.

        // Crear una nueva lista de reproducción.
        Playlist playlist = new Playlist();

        // Procesar las operaciones especificadas.
        for (int i = 0; i < n; i++) {
            String[] x = scanner.nextLine().split(" ");
            String operation = x[0]; // Identificar el tipo de operación.

            // Ejecutar la operación correspondiente.
            switch (operation) {
                case "PUSH_BACK":
                    // Agregar un nodo al final de la lista.
                    int idBack = Integer.parseInt(x[1]);
                    String nameBack = x[2];
                    playlist.insertarAlFinal(idBack, nameBack);
                    break;
                case "PUSH_FRONT":
                    // Agregar un nodo al inicio de la lista.
                    int idFront = Integer.parseInt(x[1]);
                    String nameFront = x[2];
                    playlist.insertarAlInicio(idFront, nameFront);
                    break;
                case "INSERT":
                    // Insertar un nodo después del nodo actual.
                    int idInsert = Integer.parseInt(x[1]);
                    String nameInsert = x[2];
                    playlist.insertar(idInsert, nameInsert);
                    break;
                case "DELETE":
                    // Eliminar un nodo por su ID.
                    int idDelete = Integer.parseInt(x[1]);
                    playlist.delete(idDelete);
                    break;
                case "NEXT":
                    // Avanzar al siguiente nodo.
                    playlist.next();
                    break;
                case "PREV":
                    // Retroceder al nodo anterior.
                    playlist.prev();
                    break;
                case "PLAY":
                    // Reproducir el nodo actual.
                    playlist.play();
                    break;
                case "PRINT_ALL":
                    // Imprimir todos los nodos de la lista.
                    playlist.printAll();
                    break;
                default:
                    // Manejar operaciones no reconocidas.
                    System.out.println("Operación no reconocida: " + operation);
                    break;
            }
        }

        // Cerrar el scanner para liberar recursos.
        scanner.close();
    }
}

// Clase que representa una lista circular doblemente enlazada.
class Playlist {

    // Clase interna que define un nodo en la lista.
    static class Nodo {
        int id; // Identificador único del nodo.
        String nombre; // Nombre asociado al nodo.
        Nodo siguiente; // Referencia al nodo siguiente.
        Nodo anterior; // Referencia al nodo anterior.

        // Constructor del nodo.
        public Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.siguiente = this.anterior = this; // Nodo apuntando a sí mismo (lista circular).
        }
    }

    private Nodo actual; // Referencia al nodo actual.

    // Agregar un nodo al final de la lista.
    public void insertarAlFinal(int id, String nombre) {
        Nodo nuevo = new Nodo(id, nombre);
        if (actual == null) {
            actual = nuevo; // Si la lista está vacía, el nuevo nodo es el único nodo.
        } else {
            Nodo cola = actual.anterior; // Nodo final de la lista.
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = actual;
            actual.anterior = nuevo;
        }
    }

    // Agregar un nodo al inicio de la lista.
    public void insertarAlInicio(int id, String nombre) {
        Nodo nuevo = new Nodo(id, nombre);
        if (actual == null) {
            actual = nuevo; // Lista vacía: el nuevo nodo es el único nodo.
        } else {
            Nodo tail = actual.anterior; // Nodo final.
            nuevo.siguiente = actual;
            nuevo.anterior = tail;
            tail.siguiente = nuevo;
            actual.anterior = nuevo;
        }
        actual = nuevo; // El nuevo nodo se convierte en el actual.
    }

    // Insertar un nodo después del nodo actual.
    public void insertar(int id, String nombre) {
        Nodo nuevo = new Nodo(id, nombre);
        if (actual == null) {
            actual = nuevo; // Lista vacía.
        } else {
            Nodo siguienteNodo = actual.siguiente;
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            nuevo.siguiente = siguienteNodo;
            siguienteNodo.anterior = nuevo;
        }
    }

    // Eliminar un nodo por su ID.
    public void delete(int id) {
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = actual;
        do {
            if (temp.id == id) {
                if (temp.siguiente == temp) {
                    actual = null; // Si solo hay un nodo, la lista queda vacía.
                } else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                    if (temp == actual) {
                        actual = temp.siguiente; // Actualizar nodo actual si es eliminado.
                    }
                }
                System.out.println("Nodo eliminado: " + id);
                return;
            }
            temp = temp.siguiente;
        } while (temp != actual);

        System.out.println("Nodo con ID " + id + " no encontrado.");
    }

    // Avanzar al siguiente nodo.
    public void next() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    // Retroceder al nodo anterior.
    public void prev() {
        if (actual != null) {
            actual = actual.anterior;
        }
    }

    // Reproducir el nodo actual.
    public void play() {
        if (actual != null) {
            System.out.println(actual.nombre);
        }
    }

    // Imprimir todos los nodos de la lista.
    public void printAll() {
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return; // Lista vacía.
        }

        Nodo temp = actual;
        StringBuilder result = new StringBuilder();

        do {
            result.append(temp.nombre).append(" ");
            temp = temp.siguiente;
        } while (temp != actual);

        // Imprimir todos los nombres de los nodos.
        System.out.println(result.toString().trim());
    }
}