package chapter3;

public interface Stack<T> {
    public void push(T item);
    public T pop();
    public boolean isEmpty();
    public int size();
}