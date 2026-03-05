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
        stackBasedPalindromeCheck(); //UC5
        queueStackPalindromeCheck(); //UC6
        dequeBasedPalindromeCheck(); //UC7
        linkedListBasedPalindromeCheck(); //UC8
        recursivePalindromeCheck(); //UC9
        caseInsensitiveSpaceIgnoredCheck(); //UC10
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
        System.out.println("Is it a Palindrome? : " + input.equals(reversed));
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
        System.out.println();
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

    //UC8 : Linked List Based Palindrome Checker
    public static void linkedListBasedPalindromeCheck() {
        String input = "level";
        LinkedListNode head = createLinkedList(input);

        System.out.print("UC8 Linked List: ");
        printLinkedList(head);

        boolean isPalindrome = isPalindromeLinkedList(head);
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    // Node class
    static class LinkedListNode {
        char data;
        LinkedListNode next;

        LinkedListNode(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static LinkedListNode createLinkedList(String str) {
        if (str == null || str.isEmpty()) return null;

        LinkedListNode head = new LinkedListNode(str.charAt(0));
        LinkedListNode current = head;

        for (int i = 1; i < str.length(); i++) {
            current.next = new LinkedListNode(str.charAt(i));
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static boolean isPalindromeLinkedList(LinkedListNode head) {
        if (head == null || head.next == null) return true;

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode secondHalf = reverseLinkedList(slow.next);

        LinkedListNode firstHalf = head;
        LinkedListNode tempSecond = secondHalf;
        boolean palindrome = true;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        slow.next = reverseLinkedList(secondHalf);

        return palindrome;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    //UC9 : Recursive Palindrome Checker
    public static void recursivePalindromeCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text for UC9 Recursive Check: ");
        String input = scanner.nextLine();

        boolean isPalindrome = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("UC9 Result");
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    //UC10 : Case-Insensitive & Space-Ignored Palindrome Checker
    public static void caseInsensitiveSpaceIgnoredCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text for UC10 Case-Insensitive Check: ");
        String input = scanner.nextLine();

        // Normalize string: remove spaces and convert to lower case
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = isPalindrome(normalized);

        System.out.println("UC10 Result");
        System.out.println("Original text: " + input);
        System.out.println("Normalized text: " + normalized);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}