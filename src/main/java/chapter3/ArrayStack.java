package chapter3;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int size;

    public ArrayStack() {
        stack = (T[]) new Object[1];
    }

    @Override
    public void push(T item) {
       if (isFull()) resize(stack.length * 2);
       stack[size++] = item;
    }

    private void resize(int newSize) {
        T[] newStack = (T[]) new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else if (size == (stack.length / 4)) {
            resize(stack.length / 2);
        }
        T  item = stack[--size];
        stack[size] = null;
        return item;
    }

    private boolean isFull() {
        return  size == stack.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

   @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
}
