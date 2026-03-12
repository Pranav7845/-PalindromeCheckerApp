import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed += normalized.charAt(i);
        }
        if (normalized.equals(reversed)) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (Case-insensitive, space-ignored).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (Case-insensitive, space-ignored).");
        }

        scanner.close();
        System.out.println("Program executed successfully.");
    }
}
