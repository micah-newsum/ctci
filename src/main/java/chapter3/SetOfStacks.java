package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

public class SetOfStacks {
    List<StackWithJoin> stacks = new ArrayList<>();
    private final int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Optional<StackWithJoin> getLastStack() {
        if (stacks.isEmpty()) return Optional.empty();
        return Optional.of(stacks.get(stacks.size() - 1));
    }

    public void push(int value) {
        Optional<StackWithJoin> lastOpt = getLastStack();
        if (lastOpt.isPresent() && lastOpt.get().size() < capacity) {
            lastOpt.get().push(value);
        } else {
           StackWithJoin stack = new StackWithJoin(this.capacity);
           stack.push(value);
           stacks.add(stack);
        }
    }

    public int pop() {
       Optional<StackWithJoin> lastOpt = getLastStack();
       if (!lastOpt.isPresent() || lastOpt.get().isEmpty() ) {
           throw new EmptyStackException();
       } else {
           int value = lastOpt.get().pop();
           if (lastOpt.get().isEmpty()) stacks.remove(stacks.size() - 1);
           return value;
       }
    }

    public boolean isEmpty() {
        Optional<StackWithJoin> lastOpt = getLastStack();
        return !lastOpt.isPresent() || lastOpt.get().isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        StackWithJoin stack = stacks.get(index);
        int removedItem;
        if (removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > (index + 1)) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }
        return removedItem;
    }

    public int size() {
        return stacks.stream().mapToInt(StackWithJoin::size).sum();
    }

    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
    }
}
