import java.util.Scanner;
import java.util.Stack;

public class StackPila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(13);
        stack.push(15);
        stack.push(13);
        stack.push(15);
        stack.push(15);

        System.out.println("Los elementos ingresados son: ");
        for (Integer i : stack) {
            System.out.print(i);
        }
    }
}