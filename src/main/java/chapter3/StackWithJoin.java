package chapter3;

public class StackWithJoin {
    private final int capacity;
    private Node top, bottom;
    private int size = 0;

    public static class Node {
        int value;
        Node above;
        Node below;

        public Node(int value) {
            this.value = value;
        }
    }

    public StackWithJoin(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(int v) {
       if (size >= capacity) return false;
       size++;
       Node n = new Node(v);
       if (size == 1) bottom = n;
       join(n, top);
       top = n;
       return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        return top.value;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}
