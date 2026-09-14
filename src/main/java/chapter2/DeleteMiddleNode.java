package chapter2;

public class DeleteMiddleNode {
    public static <T> boolean deleteMiddleNode(Node<T> node) {
        if (node == null || node.next == null) return false;
        Node<T> next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        Node<String> head = new Node<>("a");
        head.next = new Node<>("b");
        Node<String> node = new Node<>("c");
        head.next.next = node;
        head.next.next.next = new Node<>("d");
        head.next.next.next.next = new Node<>("e");
        head.next.next.next.next.next = new Node<>("f");
        System.out.println(head.printList());
        deleteMiddleNode(node);
        System.out.println(head.printList());
    }
}
