import java.util.*;
public class PalindromeCheckerApp{
    public static void main(String[] args){
        showWelcome(); //UC1
        checkHardcodedPalindrome(); //UC2
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
}