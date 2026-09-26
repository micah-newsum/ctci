package chapter2;


public class isPalindrome {

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        LinkedListNode next;
        while (node != null) {
            next = new LinkedListNode(node.data);
            next.next = head;
            head = next;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(LinkedListNode head1, LinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next =  new LinkedListNode(2);
        head.next.next =  new LinkedListNode(3);
        head.next.next.next =  new LinkedListNode(2);
        head.next.next.next.next =  new LinkedListNode(1);
        System.out.println(reverseAndClone(head));
        System.out.println(isPalindrome(head));
        LinkedListNode nonPalindrome = new LinkedListNode(1);
        nonPalindrome.next =  new LinkedListNode(2);
        nonPalindrome.next.next =  new LinkedListNode(3);
        System.out.println(reverseAndClone(nonPalindrome));
        System.out.println(isPalindrome(nonPalindrome));
    }
}
