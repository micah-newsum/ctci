package chapter3;

public class SortStack {

    public static <T extends Comparable<T>> Stack<T> sort(Stack<T> stack) {
        Stack<T> sorted = new ArrayStack<>();

        // O(n^2)
        while (!stack.isEmpty()) {
            T tmp = stack.pop();

            while (!sorted.isEmpty() && tmp.compareTo(sorted.peek()) <= 0) {
                stack.push(sorted.pop());
            }
            sorted.push(tmp);
        }

        // O(n)
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }

        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(sort(stack));
    }
}
