import java.util.Scanner;

    public class ValidacionOperacion {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa la cantidad de elementos a Ingresar en la Cola: ");
            int n = scanner.nextInt();

            Cola cola = new Cola();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                cola.Enqueue(x);
            }

            System.out.println("La cantidad de elementos Ingresados: ");
            cola.Imprimir();

            System.out.println("El elemento en la parte Superior: " + cola.Top());

            System.out.println("Ahora saco un elemento de la Cola: ");
            cola.Dequeue();

            System.out.println("La cola quedaría con los siguiene Elementos: ");
            cola.Imprimir();
        }

        public static class Cola {

            //Creación de los Punteros.
            private Nodo Frente;
            private Nodo Final;

            //Constructor: Inicializar los punteros en Nulos.
            public Cola() {
                this.Frente = null;
                this.Final = null;
            }

            //Método IsEmpty: Determinar la cola contiene algún elemento previo.
            public Boolean isEmpty(){
                return this.Frente == null;
            }

            //Método Enqueue: Ingresar un valor en la Cola.
            public void Enqueue(int valor) {
                Nodo nuevo = new Nodo(valor);

                //Me pregunto si el final está vacío.
                if (this.Final == null) {
                    //En caso que la cola este vacía: Agregó un elemento al frente y al final de la cola.
                    this.Final = nuevo;
                    this.Frente = nuevo;

                } else {

                    //En caso que la cola tenga elementos: Agregó un elemento en el final de la cola.
                    this.Final.siguiente = nuevo;
                    this.Final = nuevo; //Ahora digo que el nuevo final es el nuevo elemento que se acabó de agregar.
                }
            }

            //Función Dequeue: Sacar el ultímo elemento de la cola.
            public int Dequeue() {
                if (isEmpty()) {
                    System.out.println("La cola se encuentra Vacía");
                    return -1;
                    //En caso de estar vacía retorna el mensaje.
                }

                //Ahora debo hacer un traspaso de valores.
                int numero = this.Frente.valor; //El primer nodo con el valor lo guardo en la variable "int número".
                this.Frente = this.Frente.siguiente; //Ahora asigno el puntero al siguiente, pero nodo que esta "adelante".

                //Indicación en caso de que la cola se quedo sin Elementos.
                if (this.Frente == null) {
                    this.Final = null;
                }
                return numero;
            }

            //Método Top: Imprimir el valor del elemento "Nodo" que se encuentre en la parte Superior.
            public int Top() {
                if (this.Frente == null) {
                    System.out.println("La cola se encuentra Vaca");
                    return -1;
                    //En caso de estar vacía retorna el mensaje.
                }
                return this.Frente.valor; //Retorno el "Nodo con el valor" que se encuentra en la parte superior.
            }

            public void Imprimir() {
                if (isEmpty()) {
                    System.out.println("La cola se encuentra Vacía");
                    return;
                }

                Nodo actual = this.Frente;
                while (actual != null) {
                    System.out.println(actual.valor);
                    actual = actual.siguiente;

                }
            }

            //Clase Anidada para mostrar los nodos en la Cola.
            public static class Nodo {
                private int valor;
                private Nodo siguiente;

                public Nodo (int valor) {
                    this.valor = valor;
                    this.siguiente = null;
                }
            }
        }
    }