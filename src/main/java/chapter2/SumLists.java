package chapter2;

public class SumLists {

    private static class Digit {
        int val;
    }

    public static int sumLists(LinkedListNode head1, LinkedListNode head2) {
        return calcNumOfList(head1) + calcNumOfList(head2);
    }

    public static int calcNumOfList(LinkedListNode head1) {
        int num = 0;
        int digit = 1;
        LinkedListNode current = head1;

        while (current != null) {
            num += (int) Math.pow(10, digit - 1) * current.data;
            digit++;
            current = current.next;
        }
        return num;
    }

    /**
     * O(a + b) T O(a + b) S, where a is length of first linked list and b is length of second.
     * @param head1
     * @param head2
     * @return
     */
    public static int sumListsReverse(LinkedListNode head1, LinkedListNode head2) {
        return calcNum(head1) + calcNum(head2);
    }

    private static int calcNum(LinkedListNode node) {
        Digit digit = new Digit();
        return calcNum(node, digit);
    }

    private static int calcNum(LinkedListNode node, Digit digit) {
        if (node.next == null) {
            return node.data;
        }

        int num = calcNum(node.next, digit);
        digit.val++;
        return (int) (num + (Math.pow(10, digit.val) * node.data));
    }

    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(7);
        head1.next =  new LinkedListNode(1);
        head1.next.next = new LinkedListNode(6);

        LinkedListNode head2 = new LinkedListNode(5);
        head2.next = new LinkedListNode(9);
        head2.next.next = new LinkedListNode(2);

        System.out.println(sumLists(head1, head2));

        LinkedListNode head3 = new LinkedListNode(6);
        head3.next =  new LinkedListNode(1);
        head3.next.next = new LinkedListNode(7);

        LinkedListNode head4 = new LinkedListNode(2);
        head4.next = new LinkedListNode(9);
        head4.next.next = new LinkedListNode(5);

        System.out.println(sumListsReverse(head3, head4));
    }
}
