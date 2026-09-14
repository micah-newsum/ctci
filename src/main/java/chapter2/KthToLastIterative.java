package chapter2;

public class KthToLastIterative {
    public static <T> Node<T> kthToLast(Node<T> head, int k) {
        Node<T> p2 = head;
        Node<T> p1 = head;
        int pos = 1;

        while (p1.next != null) {
            if (pos >= k) {
                p2 = p2.next;
            }
            p1 = p1.next;
            pos++;
        }

        return p2;
    }

    public static void main(String[] args) {
        Node<String> head = new Node<>("a");
        head.appendToTail("b");
        head.appendToTail("c");
        head.appendToTail("d");
        head.appendToTail("e");
        head.appendToTail("f");
        System.out.println(kthToLast(head, 5));
    }

}
