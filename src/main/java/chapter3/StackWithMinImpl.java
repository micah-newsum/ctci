package chapter3;

public class StackWithMinImpl<T extends Comparable<T>> {
    private final T[] stack;
    private final T[] minimums;
    private T currentMin;
    private int size;

    public StackWithMinImpl(int capacity) {
        stack = (T[]) new Comparable[capacity];
        minimums = (T[]) new Comparable[capacity];
    }

    public void push(T item) {
        if (currentMin == null) {
            currentMin = item;
        } else if (currentMin.compareTo(item) > 0) {
            currentMin = item;
        }
        stack[size] = item;
        minimums[size] = currentMin;
        size++;
    }

    public T pop() {
        size--;
        T item = stack[size];
        currentMin = size > 0 ? minimums[size - 1] : null;
        return item;
    }

    public T min() {
        return minimums[size - 1];
    }

    public static void main(String[] args) {
        StackWithMinImpl<String> stack = new StackWithMinImpl<>(3);
        stack.push("c");
        stack.push("b");
        stack.push("a");
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

        StackWithMinImpl<Integer> stackOfNums = new StackWithMinImpl<>(3);
        stackOfNums.push(3);
        stackOfNums.push(2);
        stackOfNums.push(1);
        System.out.println(stackOfNums.min());
        stackOfNums.pop();
        System.out.println(stackOfNums.min());
        stackOfNums.pop();
        System.out.println(stackOfNums.min());
    }
}
