package chapter3;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
}
