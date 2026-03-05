import java.util.*;
public class PalindromeCheckerApp{
    public static void main(String[] args){
        String input = "noon";
        boolean isPalindrome = isPalindromeUsingStack(input);

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    public static boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        return str.equals(reversed);
    }
}
