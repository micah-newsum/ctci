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

    public static void main(String[] args) {
        // Stack of Strings
        Stack<String> stackOfStrings = new ArrayStack<>();
        stackOfStrings.push("a");
        stackOfStrings.push("b");
        stackOfStrings.push("c");
        stackOfStrings.push("d");
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());

        // Stack of ints
        Stack<Integer> stackOfIntegers = new ArrayStack<>();
        stackOfIntegers.push(1);
        stackOfIntegers.push(2);
        stackOfIntegers.push(3);
        stackOfIntegers.push(4);
        System.out.println(stackOfIntegers.pop());
        System.out.println(stackOfIntegers.pop());
        System.out.println(stackOfIntegers.pop());
        System.out.println(stackOfIntegers.pop());
    }
}
