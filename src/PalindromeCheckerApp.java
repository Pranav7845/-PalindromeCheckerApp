import java.util.*;
public class PalindromeCheckerApp{
    public static void main(String[] args){
        showWelcome(); //UC1
        checkHardcodedPalindrome(); //UC2
        reverseBasedPalindromeCheck(); // UC3
        checkPalindromeUsingArray(); //UC4
        stackBasedPalindromeCheck(); // UC5

    }
    //UC1 : Welcome Message
    public static void showWelcome() {
        System.out.println("Welcome to the Palindrome Checker Management");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully");
    }

    public static void checkHardcodedPalindrome {
        String input = "madam";
        boolean isPalindrome = true;


        // Loop till half of the string
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Required Output Format
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

    }
    // UC3: Reverse String Based Palindrome Check
    public static void reverseBasedPalindromeCheck() {

        String input = "madam";
        String reversed = "";

        // Reverse using loop (as per your hint)
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

        // Convert String to char array
        char[] characters = input.toCharArray();

        // Two-pointer technique
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

        // Output
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
    // UC5: Stack-Based Palindrome Check
    public static void stackBasedPalindromeCheck() {
        String input = "madam";
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