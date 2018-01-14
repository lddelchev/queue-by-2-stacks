package com.x8academy.queuetask.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    private static String nodeData1;
    private static String nodeData2;
    private static String nodeData3;

    @BeforeEach
    public void initialize() {
        nodeData1 = "a simple data 1";
        nodeData2 = "a simple data 2";
        nodeData3 = "a simple data 3";
    }

    @Test
    void givenNewNodeWhenCreatedByOneArgumentConstructorThenDataValueProper() {
        Node<String> node = new Node<>(nodeData1);

        assertEquals(node.getData(), nodeData1);
    }

    @Test
    void givenNewNodeWhenCreatedByOneArgumentConstructorThenNextValueNull() {
        Node<String> node = new Node<>(nodeData1);

        assertEquals(node.getNeighbour(), null);
    }

    @Test
    void givenNewNodeWhenCreatedWithTwoArgumentConstructorThenValuesProper() {
        Node<String> secondNode = new Node<String>(nodeData2);
        Node<String> firstNode = new Node<String>(nodeData1, secondNode);

        assertEquals(firstNode.getData(), nodeData1);
        assertEquals(firstNode.getNeighbour(), secondNode);
    }

    @Test
    void givenNodeWhenNextSetThenSetProper() {
        Node<String> secondNode = new Node<>(nodeData1);
        Node<String> firstNode = new Node<>(nodeData2, secondNode);
        Node<String> thirdNode = new Node<>(nodeData3);

        firstNode.setPrevious(thirdNode);

        assertEquals(firstNode.getNeighbour(), thirdNode);
    }
}
