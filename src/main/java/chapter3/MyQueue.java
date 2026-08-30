package chapter3;

public class MyQueue<T> implements Queue<T> {
    private final Stack<T> newest;
    private final Stack<T> oldest;

    public MyQueue() {
        newest = new ArrayStack<>();
        oldest = new ArrayStack<>();
    }

    @Override
    public void enqueue(T value) {
        newest.push(value);
    }

    @Override
    public T dequeue() {
        transfer(newest, oldest);
        return oldest.pop();
    }

    private void transfer(Stack<T> source, Stack<T> target) {
        if (target.isEmpty()) {
            while (!source.isEmpty()) {
                target.push(source.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        System.out.println(queue.dequeue());
        queue.enqueue("c");
        System.out.println(queue.dequeue());
    }
}
