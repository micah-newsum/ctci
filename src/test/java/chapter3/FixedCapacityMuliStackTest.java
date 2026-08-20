package chapter3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FixedCapacityMuliStackTest {

    @Test
    void newStack_isEmpty_returnsTrueForAnyStackNumber() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));
    }

    @Test
    void newStack_size_returnsZeroForAnyStackNumber() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(0, stack.size(2));
    }

    @Test
    void push_thenIsEmpty_returnsFalse() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);

        assertFalse(stack.isEmpty(0));
    }

    @Test
    void push_thenSize_incrementsByOne() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);
        stack.push(0, 2);

        assertEquals(2, stack.size(0));
    }

    @Test
    void pushMultiple_thenPop_returnsInReverseOrder() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);

        assertEquals(3, stack.pop(0));
        assertEquals(2, stack.pop(0));
        assertEquals(1, stack.pop(0));
    }

    @Test
    void pushAndPopInterleaved_maintainsLifoOrder() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);
        stack.push(0, 2);
        assertEquals(2, stack.pop(0));

        stack.push(0, 3);
        assertEquals(3, stack.pop(0));
        assertEquals(1, stack.pop(0));
    }

    @Test
    void pushToOneStack_doesNotAffectOtherStacksSizeOrEmptiness() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);
        stack.push(0, 2);

        assertTrue(stack.isEmpty(1));
        assertEquals(0, stack.size(1));
        assertEquals(2, stack.size(0));
    }

    @Test
    void interleavedPushAcrossStacks_popReturnsCorrectValuesPerStack() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 10);
        stack.push(1, 20);
        stack.push(2, 30);
        stack.push(0, 11);
        stack.push(1, 21);
        stack.push(2, 31);

        assertEquals(31, stack.pop(2));
        assertEquals(21, stack.pop(1));
        assertEquals(11, stack.pop(0));
        assertEquals(30, stack.pop(2));
        assertEquals(20, stack.pop(1));
        assertEquals(10, stack.pop(0));
    }

    @Test
    void sizePerStack_reflectsOnlyThatStacksPushes() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, 1);
        stack.push(1, 2);
        stack.push(1, 3);
        stack.push(2, 4);
        stack.push(2, 5);
        stack.push(2, 6);

        assertEquals(1, stack.size(0));
        assertEquals(2, stack.size(1));
        assertEquals(3, stack.size(2));
    }

    @Test
    void push_whenTotalCapacityReached_throwsIllegalStateException() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(3);

        stack.push(0, 1);
        stack.push(1, 2);
        stack.push(2, 3);

        assertThrows(IllegalStateException.class, () -> stack.push(0, 4));
    }

    @Test
    void push_afterPopFreeingSpace_succeedsAgain() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(3);

        stack.push(0, 1);
        stack.push(1, 2);
        stack.push(2, 3);
        stack.pop(0);

        stack.push(1, 4);

        assertEquals(4, stack.pop(1));
    }

    @Test
    void capacityZero_firstPushThrowsImmediately() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(0);

        assertThrows(IllegalStateException.class, () -> stack.push(0, 1));
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9);

        assertThrows(EmptyStackException.class, () -> stack.pop(0));
    }

    @Test
    void push_withStringItems_popReturnsCorrectStringInLifoOrder() {
        FixedCapacityMuliStack<String> stack = new FixedCapacityMuliStack<>(9);

        stack.push(0, "first");
        stack.push(0, "second");

        assertEquals("second", stack.pop(0));
        assertEquals("first", stack.pop(0));
    }
}
