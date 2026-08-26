package chapter3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackWithMinCompositionTest {

    @Test
    void newStack_isEmpty_returnsTrue() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    void newStack_size_returnsZero() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        assertEquals(0, stack.size());
    }

    @Test
    void newStack_min_returnsNull() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        assertNull(stack.min());
    }

    @Test
    void push_thenIsEmpty_returnsFalse() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void push_thenSize_incrementsByOne() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
    }

    @Test
    void push_singleItem_minReturnsThatItem() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(5);

        assertEquals(5, stack.min());
    }

    @Test
    void pushDescendingValues_minTracksSmallestPushed() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

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
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(1, stack.min());
    }

    @Test
    void pushDuplicateMinValues_popOne_minRemainsSame() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(2);
        stack.push(1);
        stack.push(1);

        assertEquals(1, stack.min());

        stack.pop();

        assertEquals(1, stack.min());
    }

    @Test
    void pop_afterPoppingCurrentMin_minRevertsToNextSmallest() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

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
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.pop();

        assertNull(stack.min());
    }

    @Test
    void pushMultiple_thenPop_returnsInReverseOrder() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void peek_returnsTopItemWithoutRemovingIt() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        StackWithMinComposition<Integer> stack = new StackWithMinComposition<>();

        assertThrows(EmptyStackException.class, stack::pop);
    }
}
