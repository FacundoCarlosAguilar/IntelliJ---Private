import java.util.Scanner;

/**
 * Programa para gestionar una lista doblemente enlazada que representa una lista de reproducción (playlist).
 * Permite operaciones como agregar canciones al inicio o final, insertar, eliminar, y navegar entre canciones.
 */
public class ListaDoblemente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        // Crear una nueva playlist.
        Playlist playlist = new Playlist();

        // Procesar los comandos.
        // Reutilización de código - Ayudar del Profesor.
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "PUSH_BACK": // Agregar canción al final.
                    playlist.agregarFinal(Integer.parseInt(command[1]), command[2]);
                    break;
                case "PUSH_FRONT": // Agregar canción al inicio.
                    playlist.agregarInicio(Integer.parseInt(command[1]), command[2]);
                    break;
                case "INSERT": // Insertar canción antes de la canción actual.
                    playlist.insertar(Integer.parseInt(command[1]), command[2]);
                    break;
                case "DELETE": // Eliminar canción por ID.
                    playlist.eliminar(Integer.parseInt(command[1]));
                    break;
                case "NEXT": // Avanzar a la siguiente canción.
                    playlist.siguiente();
                    break;
                case "PREV": // Retroceder a la canción anterior.
                    playlist.anterior();
                    break;
                case "PLAY": // Reproducir la canción actual.
                    System.out.println(playlist.reproducir());
                    break;
                case "PRINT_ALL": // Imprimir todas las canciones de la playlist.
                    System.out.println(playlist.imprimirTodo());
                    break;
            }
        }

        scanner.close();
    }

    // Clase anidada Playlist.
    static class Playlist {
        private Cancion inicio;    // Referencia al primer nodo de la lista.
        private Cancion fin;       // Referencia al último nodo de la lista.
        private Cancion actual;    // Referencia a la canción actual.


        // Id: Canción.
        // Nombre: Canción.
        public void agregarFinal(int id, String nombre) {
            Cancion nuevaCancion = new Cancion(id, nombre);

            // Primer Caso: Si la lista está completamente vacía.
            if (inicio == null) { // Si la lista está vacía.
                inicio = fin = actual = nuevaCancion;
            } else {

                // Segundo Caso: Si la lista contiene al menos algún elemento.
                fin.siguiente = nuevaCancion;
                nuevaCancion.anterior = fin;
                fin = nuevaCancion;
            }
        }

        public void agregarInicio(int id, String nombre) {
            Cancion nuevaCancion = new Cancion(id, nombre);
            if (inicio == null) { // Si la lista está vacía.
                inicio = fin = actual = nuevaCancion;
            } else {
                nuevaCancion.siguiente = inicio;
                inicio.anterior = nuevaCancion;
                inicio = nuevaCancion;
            }
        }

        public void insertar(int id, String nombre) {
            if (actual == null) { // Si la lista está vacía, agregar al final.
                agregarFinal(id, nombre);
                return;
            }
            Cancion nuevaCancion = new Cancion(id, nombre);
            nuevaCancion.siguiente = actual;
            nuevaCancion.anterior = actual.anterior;
            if (actual.anterior != null) {
                actual.anterior.siguiente = nuevaCancion;
            } else {
                inicio = nuevaCancion;
            }
            actual.anterior = nuevaCancion;
        }

        /**
         * Elimina una canción de la playlist por su ID.
         *
         * @param id ID de la canción a eliminar.
         */
        public void eliminar(int id) {
            Cancion temp = inicio;
            while (temp != null && temp.id != id) {
                temp = temp.siguiente;
            }
            if (temp == null) return; // Canción no encontrada.

            if (temp.anterior != null) {
                temp.anterior.siguiente = temp.siguiente;
            } else {
                inicio = temp.siguiente;
            }

            if (temp.siguiente != null) {
                temp.siguiente.anterior = temp.anterior;
            } else {
                fin = temp.anterior;
            }

            if (actual == temp) {
                actual = temp.siguiente != null ? temp.siguiente : inicio;
            }
        }

        /**
         * Avanza a la siguiente canción.
         */
        public void siguiente() {
            actual = (actual != null && actual.siguiente != null) ? actual.siguiente : inicio;
        }

        /**
         * Retrocede a la canción anterior.
         */
        public void anterior() {
            actual = (actual != null && actual.anterior != null) ? actual.anterior : fin;
        }

        /**
         * Devuelve el nombre de la canción actual.
         *
         * @return Nombre de la canción actual o "No song" si la playlist está vacía.
         */
        public String reproducir() {
            return actual != null ? actual.nombre : "No song";
        }

        /**
         * Imprime los nombres de todas las canciones en la playlist.
         *
         * @return Una cadena con los nombres de las canciones separados por espacios.
         */
        public String imprimirTodo() {
            StringBuilder sb = new StringBuilder();
            Cancion temp = inicio;
            while (temp != null) {
                sb.append(temp.nombre).append(" ");
                temp = temp.siguiente;
            }
            return sb.toString().trim();
        }
    }

    /**
     * Clase que representa una canción en la playlist.
     */
    static class Cancion {
        int id;           // ID de la canción.
        String nombre;    // Nombre de la canción.
        Cancion siguiente; // Referencia al siguiente nodo.
        Cancion anterior; // Referencia al nodo anterior.

        public Cancion(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
    }
}