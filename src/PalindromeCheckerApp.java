import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        if (isPalindromeRecursive(input, 0, input.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (Recursive check).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (Recursive check).");
        }

        scanner.close();
        System.out.println("Program executed successfully.");
    }
}
