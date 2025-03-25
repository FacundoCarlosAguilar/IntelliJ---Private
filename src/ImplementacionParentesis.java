import java.util.Scanner;
import java.util.Stack;

public class ImplementacionParentesis {
    public static void main(String[] args) {

        /* PREGUNTAR SOBRE ESTE EJERCICIO */

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Leemos la cadena de paréntesis
        scanner.close();

        if (isValid(s)) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> pila = new Stack<>();

        // Iteramos sobre la cadena de paréntesis
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si encontramos un paréntesis de apertura, lo agregamos a la pila
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            }
            // Si encontramos un paréntesis de cierre
            else if (c == ')' || c == '}' || c == ']') {
                // Si la pila está vacía, no hay paréntesis de apertura para este cierre
                if (pila.isEmpty()) {
                    return false;
                }
                        char top = pila.pop(); // Sacamos el paréntesis de apertura de la pila

                // Verificamos si el paréntesis de cierre corresponde al de apertura
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Si al final la pila está vacía, significa que todos los paréntesis se emparejaron correctamente
        return pila.isEmpty();
    }
}