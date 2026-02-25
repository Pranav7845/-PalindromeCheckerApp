import java.util.*;
public class PalindromeCheckerApp{
    public static void main(String[] args){
        showWelcome(); //UC1
        checkHardcodedPalindrome(); //UC2
        reverseBasedPalindromeCheck(); // UC3

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
}