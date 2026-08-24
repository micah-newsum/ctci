package chapter3;

import java.util.EmptyStackException;
import java.util.HashMap;

public class FixedCapacityMuliStack<Item> {
    private final Item[] items;
    private final int capacity;
    private final int numberOfStacks;
    private final HashMap<Integer, Integer> stackSizes = new HashMap<>();

    public FixedCapacityMuliStack(int capacity, int numberOfStacks){
        this.capacity = capacity;
        items = (Item[]) new Object[this.capacity];
        this.numberOfStacks = numberOfStacks;
    }

    public void push(int stackNumber, Item item) {
        if (stackNumber < 0 || stackNumber > numberOfStacks) throw new IllegalArgumentException(String.format("Stack number: %d out of bounds \n",stackNumber));
        int stackSize = stackSizes.getOrDefault(stackNumber, 0);
        if (stackSize == capacity / numberOfStacks) throw new IllegalStateException(String.format("Stack %d at capacity \n",stackNumber));
        int index = getCurrentIndex(stackNumber);
        items[index] = item;
        stackSizes.put(stackNumber, stackSize + 1);
    }

    public Item pop(int stackNumber) {
        if (stackNumber < 0 || stackNumber > numberOfStacks) throw new IllegalArgumentException(String.format("Stack number: %d out of bounds \n",stackNumber));
        int stackSize = stackSizes.getOrDefault(stackNumber, 0);
        if (stackSize == 0) throw new EmptyStackException();
        int index = getCurrentIndex(stackNumber) - 1;
        Item item =  items[index];
        items[stackSize] = null;
        stackSizes.put(stackNumber, stackSize - 1);
        return item;
    }

    private int getCurrentIndex(int stackNumber){
        return ((capacity /numberOfStacks) * (stackNumber - 1)) + stackSizes.getOrDefault(stackNumber, 0);
    }

    public boolean isEmpty(int stackNumber) {
        return size(stackNumber) == 0;
    }

    public int size(int stackNumber) {
        return stackSizes.getOrDefault(stackNumber, 0);
    }
}

