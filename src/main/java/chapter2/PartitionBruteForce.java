package chapter2;

public class PartitionBruteForce {
    public static void partition(Node<Integer> head, int partition) {
        Node<Integer> p1 = head;
        Node<Integer> p2;

        while (p1.next != null) {
            if (p1.data >= partition) {
                p2 = p1.next;
                while (p2 != null) {
                    if (p2.data < partition) {
                        int temp = p1.data;
                        p1.data = p2.data;
                        p2.data = temp;
                    }
                    p2 = p2.next;
                }
            }

            p1 = p1.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        partition(head, 5);
        System.out.println(head.printList());
    }
}
