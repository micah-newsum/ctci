package chapter3;

import java.util.EmptyStackException;

public class StackWithMinSubclassing<T extends Comparable<T>> extends ArrayStack<T> implements Minable<T> {
    private final Stack<T> minStack;

    public StackWithMinSubclassing() {
        minStack = new ArrayStack<>();
    }

    @Override
    public void push(T item) {
        if (super.isEmpty()) {
            minStack.push(item);
        } else if (item.compareTo(minStack.peek()) <= 0) {
            minStack.push(item);
        }
        super.push(item);
    }

    @Override
    public T pop() {
        if (super.peek() == minStack.peek()) {
            minStack.pop();
        }
        return super.pop();
    }

    @Override
    public T peek() {
        return super.peek();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
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
