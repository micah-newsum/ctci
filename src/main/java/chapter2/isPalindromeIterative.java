package chapter2;

import chapter3.ArrayStack;
import chapter3.Stack;

public class isPalindromeIterative {

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        Stack<Integer> stack = new ArrayStack<>();

        while (fast != null &&  fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }


    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(1);
        System.out.println(isPalindrome(head));

        LinkedListNode palEven = new LinkedListNode(1);
        palEven.next = new LinkedListNode(2);
        palEven.next.next = new LinkedListNode(2);
        palEven.next.next.next = new LinkedListNode(1);
        System.out.println(isPalindrome(palEven));

        LinkedListNode nonPal = new LinkedListNode(1);
        nonPal.next = new LinkedListNode(2);
        nonPal.next.next = new LinkedListNode(3);
        System.out.println(isPalindrome(nonPal));
    }
}
