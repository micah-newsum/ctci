package chapter2;

public class Node<T> {
    Node<T> next = null;
    T data;

    public Node(T data) {
        this.data = data;
    }

    void appendToTail(T data) {
        Node<T> end = new Node<>(data);
        Node<T> n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> n = this;
        while (n != null) {
            sb.append(n.data.toString() + ",");
            n = n.next;
        }
        return sb.toString();
    }
}
