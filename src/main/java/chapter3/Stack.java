package chapter3;

public interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    int size();
}