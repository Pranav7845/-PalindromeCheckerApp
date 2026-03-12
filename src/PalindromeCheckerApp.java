import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        return input.equals(reversed);
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("Select strategy: 1-Stack, 2-Deque");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PalindromeContext context = new PalindromeContext();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            context.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice. Defaulting to Stack strategy.");
            context.setStrategy(new StackStrategy());
        }

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (Strategy Pattern).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (Strategy Pattern).");
        }

        scanner.close();
        System.out.println("Program executed successfully.");
    }
}
