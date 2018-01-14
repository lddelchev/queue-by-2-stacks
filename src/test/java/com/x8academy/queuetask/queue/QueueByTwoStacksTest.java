package com.x8academy.queuetask.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueByTwoStacksTest {
    private static Queue<String> queue;
    private static String exampleData;
    private static String exampleData1;
    private static String exampleData2;
    private static String exampleData3;

    @BeforeEach
    void createEmptyStack() {
        queue = new QueueByTwoStacks<>();
        exampleData = "example data";
        exampleData1 = "example data 1";
        exampleData2 = "example data 2";
        exampleData3 = "example data 3";
    }

    @Test
    void givenNewlyCreatedQueueWhenEmptyMethodCalledThenItReturnsTrue() {
        assertTrue(queue.empty());
    }

    @Test
    void givenNonEmptyQueueWhenEmptyMethodCalledThenItReturnsFalse() {
        queue.push(exampleData);

        assertFalse(queue.empty());
    }

    @Test
    void givenEmptyQueueWhenNewElementPushedThenItIsReturnedByPeek() {
        queue.push(exampleData);
        assertEquals(exampleData, queue.peek());
    }

    @Test
    void givenNonEmptyQueuekWhenPeekCalledTheTopElementDoesNotChange() {
        queue.push(exampleData);
        queue.push(exampleData1);
        queue.peek();
        assertEquals(exampleData, queue.peek());
    }

    @Test
    void givenEmptyQueueWhenNewElementPushedThenItIsReturnedByPop() {
        queue.push(exampleData);
        assertEquals(exampleData, queue.pop());
    }

    @Test
    void givenOneElementQueueWhenPopCalledThenItBecomesEmpty() {
        queue.push(exampleData);
        queue.pop();
        assertTrue(queue.empty());
    }

    @Test
    void givenMultiplePushesWhenPopCalledThenTheFifoOrderIsPreserved() {
        List<String> elementsToInsert = new ArrayList<>();
        elementsToInsert.add(exampleData1);
        elementsToInsert.add(exampleData2);
        elementsToInsert.add(exampleData3);

        for (int i=0; i<elementsToInsert.size(); i++) {
            queue.push(elementsToInsert.get(i));
        }

        for (int i=0; i<elementsToInsert.size(); i++) {
            assertEquals(elementsToInsert.get(i), queue.pop());
        }
    }

    @Test
    void givenQueueWhenConsecutivePushesAndPopsThenFifoOrderIsPreserved() {
        queue.push(exampleData);
        queue.push(exampleData1);
        queue.push(exampleData2);
        queue.pop();
        queue.push(exampleData3);

        assertEquals(exampleData1, queue.pop());
        assertEquals(exampleData2, queue.pop());
        assertEquals(exampleData3, queue.pop());
    }

    @Test
    void givenQueueWhenEqualElementsPushedThenTheyAppearMultipleTimes() {
        queue.push(exampleData1);
        queue.push(exampleData1);
        queue.push(exampleData);

        assertEquals(exampleData1, queue.pop());
        assertEquals(exampleData1, queue.pop());
    }
}