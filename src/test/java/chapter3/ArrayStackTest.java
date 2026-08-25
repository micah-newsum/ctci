package chapter3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayStackTest {

    @Test
    void newStack_isEmpty_returnsTrue() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    void newStack_size_returnsZero() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        assertEquals(0, stack.size());
    }

    @Test
    void push_thenIsEmpty_returnsFalse() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void push_thenSize_incrementsByOne() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
    }

    @Test
    void pushMultiple_thenPop_returnsInReverseOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pushAndPopInterleaved_maintainsLifoOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());

        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void push_beyondInitialCapacity_resizesAndRetainsOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        assertEquals(5, stack.size());
        for (int i = 5; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void pop_manyTimes_shrinksBackingArrayButPreservesRemainingOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 1; i <= 8; i++) {
            stack.push(i);
        }

        for (int i = 8; i >= 3; i--) {
            assertEquals(i, stack.pop());
        }

        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void push_withStringItems_popReturnsCorrectStringInLifoOrder() {
        ArrayStack<String> stack = new ArrayStack<>();

        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
    }

    @Test
    void size_afterPushAndPop_reflectsCurrentCount() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.push(3);
        stack.push(4);
        assertEquals(3, stack.size());
    }
}
