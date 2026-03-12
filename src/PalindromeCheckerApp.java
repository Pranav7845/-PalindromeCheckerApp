import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static boolean isPalindromeStringReverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }
    public static boolean isPalindromeStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        return input.equals(reversed);
    }
    public static boolean isPalindromeDeque(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        long startTime, endTime;
        startTime = System.nanoTime();
        boolean result1 = isPalindromeStringReverse(input);
        endTime = System.nanoTime();
        System.out.println("String Reverse result: " + result1 + ", Time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        boolean result2 = isPalindromeStack(input);
        endTime = System.nanoTime();
        System.out.println("Stack-based result: " + result2 + ", Time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        boolean result3 = isPalindromeDeque(input);
        endTime = System.nanoTime();
        System.out.println("Deque-based result: " + result3 + ", Time: " + (endTime - startTime) + " ns");

        scanner.close();
        System.out.println("Performance comparison completed.");
    }
}
