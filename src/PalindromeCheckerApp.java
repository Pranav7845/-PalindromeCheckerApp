import java.util.*;
public class PalindromeCheckerApp{
    public static void main(String[] args){
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