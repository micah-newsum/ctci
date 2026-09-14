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

    public int size() {
        int size = 0;
        Node<T> current = this;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public String toString() {
        return this.data.toString();
    }

    public String printList() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = this;
        while (current != null) {
            sb.append(current.data.toString());
            sb.append("->");
            current = current.next;
        }
        return sb.toString();
    }
}
