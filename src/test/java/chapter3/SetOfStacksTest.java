package chapter3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetOfStacksTest {

    @Test
    void newStack_isEmpty_returnsTrue() {
        SetOfStacks stack = new SetOfStacks(2);

        assertTrue(stack.isEmpty());
    }

    @Test
    void newStack_size_returnsZero() {
        SetOfStacks stack = new SetOfStacks(2);

        assertEquals(0, stack.size());
    }

    @Test
    void newStack_getLastStack_returnsEmptyOptional() {
        SetOfStacks stack = new SetOfStacks(2);

        assertFalse(stack.getLastStack().isPresent());
    }

    @Test
    void push_singleItem_sizeIsOne() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);

        assertEquals(1, stack.size());
    }

    @Test
    void push_singleItem_isEmptyReturnsFalse() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void push_singleItem_getLastStackPeeksThatValue() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);

        assertEquals(1, stack.getLastStack().get().peek());
    }

    @Test
    void push_beyondCapacity_sizeAccumulatesAcrossInternalStacks() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    void push_thenPop_returnsLastPushedValue() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
    }

    @Test
    void push_acrossMultipleInternalStacks_pop_returnsValuesInLifoOrder() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pop_reducesSize() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);
        stack.push(2);
        stack.pop();

        assertEquals(1, stack.size());
    }

    @Test
    void pop_lastItem_isEmptyReturnsTrue() {
        SetOfStacks stack = new SetOfStacks(2);

        stack.push(1);
        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    void pop_onEmptyStack_throwsEmptyStackException() {
        SetOfStacks stack = new SetOfStacks(2);

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void popAt_whenOnlyOneInternalStackExists_doesNotShiftAndReducesSize() {
        SetOfStacks stack = new SetOfStacks(2);
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.popAt(0));
        assertEquals(1, stack.size());
    }

    @Test
    void popAt_removesFromSpecifiedStack_andShiftsValuesFromLaterStacksUp() {
        SetOfStacks stack = new SetOfStacks(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(2, stack.popAt(0));
        assertEquals(3, stack.popAt(0));
        assertEquals(4, stack.popAt(0));
        assertEquals(1, stack.popAt(0));
    }

    @Test
    void popAt_removingLastItem_reducesOverallSize() {
        SetOfStacks stack = new SetOfStacks(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.popAt(0);

        assertEquals(2, stack.size());
    }
}
