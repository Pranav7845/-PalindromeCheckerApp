import java.util.Scanner;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node stringToLinkedList(String s) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < s.length(); i++) {
            Node newNode = new Node(s.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverseList(slow.next);
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        slow.next = reverseList(secondHalf);

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        Node head = stringToLinkedList(input);
        if (isPalindrome(head)) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (Linked List check).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (Linked List check).");
        }

        scanner.close();
        System.out.println("Program executed successfully.");
    }
}
