package chapter2;

public class PartitionV2 {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode node = head;
        node.next = new LinkedListNode(5);
        node = node.next;
        node.next = new LinkedListNode(8);
        node = node.next;
        node.next = new LinkedListNode(5);
        node = node.next;
        node.next = new LinkedListNode(10);
        node = node.next;
        node.next = new LinkedListNode(2);
        node = node.next;
        node.next = new LinkedListNode(1);
        System.out.println(head);
        System.out.println(partition(head, 5));
    }
}
