import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (Queue + Stack validation).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (Queue + Stack validation).");
        }

        scanner.close();
        System.out.println("Program executed successfully.");
    }
}
