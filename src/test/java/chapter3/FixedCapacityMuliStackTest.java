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
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));
        assertTrue(stack.isEmpty(3));
    }

    @Test
    void newStack_size_returnsZeroForAnyStackNumber() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        assertEquals(0, stack.size(1));
        assertEquals(0, stack.size(2));
        assertEquals(0, stack.size(3));
    }

    @Test
    void push_thenIsEmpty_returnsFalse() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, 1);

        assertFalse(stack.isEmpty(1));
    }

    @Test
    void push_thenSize_incrementsByOne() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, 1);
        stack.push(1, 2);

        assertEquals(2, stack.size(1));
    }

    @Test
    void pushMultiple_thenPop_returnsInReverseOrder() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);

        assertEquals(3, stack.pop(1));
        assertEquals(2, stack.pop(1));
        assertEquals(1, stack.pop(1));
    }

    @Test
    void pushAndPopInterleaved_maintainsLifoOrder() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9,3);

        stack.push(1, 1);
        stack.push(1, 2);
        assertEquals(2, stack.pop(1));

        stack.push(1, 3);
        assertEquals(3, stack.pop(1));
        assertEquals(1, stack.pop(1));
    }

    @Test
    void pushToOneStack_doesNotAffectOtherStacksSizeOrEmptiness() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, 1);
        stack.push(1, 2);

        assertTrue(stack.isEmpty(2));
        assertEquals(0, stack.size(2));
        assertEquals(2, stack.size(1));
    }

    @Test
    void interleavedPushAcrossStacks_popReturnsCorrectValuesPerStack() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9,3);

        stack.push(1, 10);
        stack.push(2, 20);
        stack.push(3, 30);
        stack.push(1, 11);
        stack.push(2, 21);
        stack.push(3, 31);

        assertEquals(31, stack.pop(3));
        assertEquals(21, stack.pop(2));
        assertEquals(11, stack.pop(1));
        assertEquals(30, stack.pop(3));
        assertEquals(20, stack.pop(2));
        assertEquals(10, stack.pop(1));
    }

    @Test
    void sizePerStack_reflectsOnlyThatStacksPushes() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, 1);
        stack.push(2, 2);
        stack.push(2, 3);
        stack.push(3, 4);
        stack.push(3, 5);
        stack.push(3, 6);

        assertEquals(1, stack.size(1));
        assertEquals(2, stack.size(2));
        assertEquals(3, stack.size(3));
    }

    @Test
    void push_whenTotalCapacityReached_throwsIllegalStateException() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(3, 3);

        stack.push(1, 1);

        assertThrows(IllegalStateException.class, () -> stack.push(1, 4));
    }

    @Test
    void push_afterPopFreeingSpace_succeedsAgain() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(3, 3);

        stack.push(1, 1);
        stack.pop(1);
        stack.push(1, 4);

        assertEquals(4, stack.pop(1));
    }

    @Test
    void capacityZero_firstPushThrowsImmediately() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(0, 3);

        assertThrows(IllegalStateException.class, () -> stack.push(0, 1));
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        FixedCapacityMuliStack<Integer> stack = new FixedCapacityMuliStack<>(9, 1);

        assertThrows(EmptyStackException.class, () -> stack.pop(0));
    }

    @Test
    void push_withStringItems_popReturnsCorrectStringInLifoOrder() {
        FixedCapacityMuliStack<String> stack = new FixedCapacityMuliStack<>(9, 3);

        stack.push(1, "first");
        stack.push(1, "second");

        assertEquals("second", stack.pop(1));
        assertEquals("first", stack.pop(1));
    }
}
