package chapter2;

public class KthToLastRecursive {

    private static class Index {
        public int idx = 0;
    }

    public static <T> Node<T> kthToLast(Node<T> head, int k) {
        return  kthToLast(head, k, new Index());
    }

    private static <T> Node<T> kthToLast(Node<T> head, int k, Index idx) {
        // base case
        if (head == null) return null;

        Node<T> node = kthToLast(head.next, k, idx);
        idx.idx++;
        if (idx.idx == k) {
            return head;
        }

        return node;
    }

    public static void main(String[] args) {
        Node<String> head = new Node<>("a");
        head.appendToTail("b");
        head.appendToTail("c");
        head.appendToTail("d");
        head.appendToTail("e");
        System.out.println(kthToLast(head, 4));
    }
}
