package chapter2;


public class RemoveDupsWithRunner {
    public static <T> void removeDuplicates(Node<T> node) {
       Node<T> prev = node;
       Node<T> current = node;
       Node<T> runner = node.next;

       while (current != null) {
           while (runner != null) {
               if (current.data == runner.data) {
                   prev.next = runner.next;
               } else {
                   prev = runner;
               }
               runner = runner.next;
           }
           current = current.next;
       }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.appendToTail(1);
        root.appendToTail(2);
        root.appendToTail(3);
        root.appendToTail(1);

        removeDuplicates(root);
        System.out.println(root);
    }
}
