package chapter3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackWithMinSubclassingTest {

    @Test
    void newStack_isEmpty_returnsTrue() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    void newStack_size_returnsZero() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        assertEquals(0, stack.size());
    }

    @Test
    void newStack_min_returnsNull() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        assertNull(stack.min());
    }

    @Test
    void push_thenIsEmpty_returnsFalse() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void push_thenSize_incrementsByOne() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
    }

    @Test
    void push_singleItem_minReturnsThatItem() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(5);

        assertEquals(5, stack.min());
    }

    @Test
    void pushDescendingValues_minTracksSmallestPushed() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(5);
        assertEquals(5, stack.min());

        stack.push(3);
        assertEquals(3, stack.min());

        stack.push(4);
        assertEquals(3, stack.min());

        stack.push(1);
        assertEquals(1, stack.min());
    }

    @Test
    void pushAscendingValues_minStaysAtFirstPushed() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(1, stack.min());
    }

    @Test
    void pushDuplicateMinValues_popOne_minRemainsSame() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(2);
        stack.push(1);
        stack.push(1);

        assertEquals(1, stack.min());

        stack.pop();

        assertEquals(1, stack.min());
    }

    @Test
    void pop_afterPoppingCurrentMin_minRevertsToNextSmallest() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        assertEquals(1, stack.min());

        stack.pop();
        assertEquals(3, stack.min());

        stack.pop();
        assertEquals(3, stack.min());

        stack.pop();
        assertEquals(5, stack.min());
    }

    @Test
    void pop_allItems_minReturnsNullAgain() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.pop();

        assertNull(stack.min());
    }

    @Test
    void pushMultiple_thenPop_returnsInReverseOrder() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void peek_returnsTopItemWithoutRemovingIt() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        StackWithMinSubclassing<Integer> stack = new StackWithMinSubclassing<>();

        assertThrows(EmptyStackException.class, stack::pop);
    }
}
