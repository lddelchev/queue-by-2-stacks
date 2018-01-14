package com.x8academy.queuetask.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedStackTest {
    private static Stack<String> stack;
    private static String exampleData;
    private static String exampleData1;
    private static String exampleData2;
    private static String exampleData3;

    @BeforeEach
    void createEmptyStack() {
        stack = new LinkedStack<String>();
        exampleData = "example data";
        exampleData1 = "example data 1";
        exampleData2 = "example data 2";
        exampleData3 = "example data 3";
    }

    @Test
    void givenNewlyCreatedStackWhenEmptyMethodCalledThenItReturnsTrue() {
        assertTrue(stack.empty());
    }

    @Test
    void givenNonEmptyStackWhenEmptyMethodCalledThenItReturnsFalse() {
        stack.push(exampleData);
        assertFalse(stack.empty());
    }

    @Test
    void givenStackWhenNewElementPushedThenItIsReturnedByPeek() {
        stack.push(exampleData);
        assertEquals(exampleData, stack.peek());
    }

    @Test
    void givenNonEmptyStackWhenNewElementPushedThenItIsReturnedByPeek() {
        stack.push(exampleData);
        stack.push(exampleData1);
        assertEquals(exampleData1, stack.peek());
    }

    @Test
    void givenNonEmptyStackWhenPeekCalledTheTopElementDoesNotChange() {
        stack.push(exampleData);
        stack.push(exampleData1);
        stack.peek();
        assertEquals(exampleData1, stack.peek());
    }

    @Test
    void givenStackWhenNewElementPushedThenItIsReturnedByPop() {
        stack.push(exampleData);
        assertEquals(exampleData, stack.pop());
    }

    @Test
    void givenNonEmptyStackWhenNewElementPushedThenItIsReturnedByPop() {
        stack.push(exampleData);
        stack.push(exampleData1);
        assertEquals(exampleData1, stack.pop());
    }

    @Test
    void givenOneElementStackWhenPopCalledThenItBecomesEmpty() {
        stack.push(exampleData);
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void givenMultiplePushesWhenPopCalledThenTheLifoOrderIsPreserved() {
        List<String> elementsToInsert = new ArrayList<>();
        elementsToInsert.add(exampleData1);
        elementsToInsert.add(exampleData2);
        elementsToInsert.add(exampleData3);

        for (int i=0; i<elementsToInsert.size(); i++) {
            stack.push(elementsToInsert.get(i));
        }

        for (int i=elementsToInsert.size()-1; i>=0; i--) {
            assertEquals(elementsToInsert.get(i), stack.pop());
        }
    }

    @Test
    void givenStackWhenConsecutivePushesAndPopsThenLifoOrderIsPreserved() {
        stack.push(exampleData);
        stack.push(exampleData1);
        stack.pop();
        stack.push(exampleData2);

        assertEquals(exampleData2, stack.pop());
        assertEquals(exampleData, stack.pop());
    }

    @Test
    void givenStackWhenEqualElementsPushedThenTheyAppearMultipleTimes() {
        stack.push(exampleData);
        stack.push(exampleData1);
        stack.push(exampleData1);
        stack.push(exampleData1);

        assertEquals(exampleData1, stack.pop());
        assertEquals(exampleData1, stack.pop());
        assertEquals(exampleData1, stack.pop());
    }
}
