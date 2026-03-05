import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static void main(String[] args){
        showWelcome(); //UC1
        checkHardcodedPalindrome(); //UC2
        reverseBasedPalindromeCheck(); // UC3
        checkPalindromeUsingArray(); //UC4
        stackBasedPalindromeCheck(); // UC5
        queueStackPalindromeCheck(); //UC6
        dequeBasedPalindromeCheck(); //UC7
    }

    //UC1 : Welcome Message
    public static void showWelcome() {
        System.out.println("Welcome to the Palindrome Checker Management");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully");
        System.out.println();
    }

    //UC2 : Hardcoded Palindrome Check
    public static void checkHardcodedPalindrome() {
        String input = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    // UC3: Reverse String Based Palindrome Check
    public static void reverseBasedPalindromeCheck() {

        String input = "madam";
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        System.out.println("UC3 Result");
        System.out.println("Input text: " + input);

        if (input.equals(reversed)) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }

        System.out.println();
    }

    // UC4 : Character Array Based Palindrome Check
    public static void checkPalindromeUsingArray() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    // UC5: Stack-Based Palindrome Check
    public static void stackBasedPalindromeCheck() {
        String input = "noon";
        boolean isPalindrome = isPalindromeUsingStack(input);

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
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

    //UC6 : Queue Stack Palindrome Check
    public static void queueStackPalindromeCheck() {

        String input = "madam";
        boolean isPalindrome = isPalindromeUsingQueueStack(input);

        System.out.println("UC6 Result");
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    public static boolean isPalindromeUsingQueueStack(String str) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }

    //UC7 : Deque-Based Optimized Palindrome Checker
    public static void dequeBasedPalindromeCheck() {

        String input = "racecar";
        boolean isPalindrome = isPalindromeUsingDeque(input);

        System.out.println("UC7 Result");
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }

    public static boolean isPalindromeUsingDeque(String str) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }
}