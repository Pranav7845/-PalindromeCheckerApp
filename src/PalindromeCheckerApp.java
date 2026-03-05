import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp{
    public static void main(String[] args){
        String input = "madam";  // hardcoded string
        boolean isPalindrome = isPalindromeUsingQueueStack(input);

        System.out.println("UC6 Result");
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    public static boolean isPalindromeUsingQueueStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue into queue and push into stack
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }
}