import java.util.Scanner;

public class PracticaDePunteros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de elementos: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        ListaEnlazada lista = new ListaEnlazada();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa un nombre: ");
            String x = scanner.nextLine();
            lista.InsertarElemento(x);
        }

        System.out.println("Los elementos que se ingresaron:");
        lista.Imprimir();

        System.out.println(" ");

        System.out.println("Ingresa el nombre a eliminar de la lista: ");
        String nombrePersona = scanner.nextLine();

        lista.EliminarElemento(nombrePersona);

        System.out.println("Los elementos restantes son:");
        lista.Imprimir();

        scanner.close();
    }

    public static class ListaEnlazada {

        private Nodo cabeza;

        // Clase Nodo.
        class Nodo {
            private String nombre;
            private Nodo siguiente;

            // Constructor para Inicializar.
            public Nodo(String nombre) {
                this.nombre = nombre;
                this.siguiente = null;
            }
        }

        // Método para insertar elementos en la lista enlazada
        public void InsertarElemento(String nombre) {
            Nodo nuevo = new Nodo(nombre);

            // PRIMERO CASO: Si la lista se encuentra totalmente vacía se ingresa un elemento en la lista.
            if (this.cabeza == null) {
                this.cabeza = nuevo;

            // SEGUNDO CASO: Sí se desea insertar un elemento al final de la lista (cabeza).
            } else {
                Nodo aux = this.cabeza;
                while (aux.siguiente != null) { // Recorrer la lista del principio hasta el final.
                    aux = aux.siguiente; // Voy pasando de nodo en nodo hasta llegar a null.
                }
                aux.siguiente = nuevo; // Ahora asigno él (nuevo) al final de la lista, siendo ahora el nuevo final.
            }
        }

        // Método para eliminar un elemento de la lista enlazada
        public void EliminarElemento(String nombre) {

            // PRIMERO CASO: Si la lista está vacía se retorna el mensaje.
            if (this.cabeza == null) {
                System.out.println("La lista está vacía.");
                return;
            }

            // SEGUNDO CASO: Si el elemento a querer eliminar es la cabeza de la lista.
            if (this.cabeza.nombre.equals(nombre)) { // Hacemos la comprobación del nombre "Ingresado" con el último de la lista.
                this.cabeza = this.cabeza.siguiente; // En caso de coincidir reasignamos los punteros para que el último sea eliminado.
                return;
            }

            // TERCER CASO: Si el elemento a querer eliminar no se encuentra en la cabeza de la lista.
            Nodo aux = this.cabeza; // Debemos crear un nodo auxiliar el cual se usara para recorrer la lista y ser capaz de encontrar el nodo a eliminar.
            while (aux.siguiente != null && !aux.siguiente.nombre.equals(nombre)) { // Recorremos la lista hasta encontrar el nombre indicado a eliminar.
                aux = aux.siguiente; // Pasamos de nodo en nodo.
            }

            // En caso de encontrarlo lo eliminaremos.
            if (aux.siguiente != null) { // Sí es encontrado
                aux.siguiente = aux.siguiente.siguiente; // Reasignamos los punteros al siguiente para que él garbage colector lo eliminé.
            } else {
                System.out.println("Elemento no encontrado en la lista."); // En caso de no ser encontrado saldrá el mensaje.
            }
        }

        // Método para imprimir los elementos de la lista enlazada
        public void Imprimir() {
            if (this.cabeza == null) {
                System.out.println("No hay elementos en la lista.");
                return;
            }

            // Creación nodo recorrer para ir imprimiendo todos los elementos de la lista.
            Nodo recorrer = this.cabeza;
            while (recorrer != null) { // Recorrer hasta el final de la lista.
                System.out.println(recorrer.nombre); // Ir imprimiendo los nodos con su contenido.
                recorrer = recorrer.siguiente; // De nodo en nodo.
            }
            System.out.println(" ");
        }
    }
}