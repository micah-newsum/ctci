package chapter3;

import java.util.EmptyStackException;

public class StackWithMinComposition<T extends Comparable<T>> implements Stack<T>, Minable<T> {
    private final Stack<T> stack;
    private final Stack<T> minStack;

    public StackWithMinComposition() {
        stack = new ArrayStack<>();
        minStack = new ArrayStack<>();
    }

    @Override
    public void push(T item) {
        if (isEmpty()) {
            minStack.push(item);
        } else if (item.compareTo(minStack.peek()) <= 0) {
            minStack.push(item);
        }
        stack.push(item);
    }

    @Override
    public T pop() {
        T item = stack.pop();
        if (item.equals(minStack.peek())) {
            minStack.pop();
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public T min() {
        try {
            return minStack.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }
}
