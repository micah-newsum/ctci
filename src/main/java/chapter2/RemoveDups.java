package chapter2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static <T> void removeDuplicates(Node<T> head) {
        Set<T> values = new HashSet<>();
        Node<T> previous = null;
        Node<T> current = head;
        while (current != null) {
            if (values.contains(current.data)) {
                previous.next = current.next;
            } else {
                values.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node<String> list = new Node<>("a");
        list.appendToTail("b");
        list.appendToTail("c");
        list.appendToTail("a");
        list.appendToTail("d");
        list.appendToTail("b");
        RemoveDups.removeDuplicates(list);
        System.out.println(list);

        Node<Integer> ints = new Node<>(1);
        ints.appendToTail(1);
        ints.appendToTail(2);
        ints.appendToTail(2);
        ints.appendToTail(3);
        ints.appendToTail(4);
        RemoveDups.removeDuplicates(ints);
        System.out.println(ints);
    }
}
