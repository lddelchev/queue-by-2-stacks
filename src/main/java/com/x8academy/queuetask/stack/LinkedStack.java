package com.x8academy.queuetask.stack;

/**
 * Linked implementation of stack.
 * @param <E> the type of the elements in the stack.
 */
public class LinkedStack<E> implements Stack<E> {
    /**
     * The last element in the stack.
     */
    private Node<E> top = null;

    /**
     * Checks if the stack is empty.
     * @return true if the stack has no elements and false if it contains
     * at least one element
     */
    public boolean empty() {
        return top == null;
    }

    /**
     * Looks for the object at the top of this stack without removing it.
     * @return the element at the top of this stack.
     */
    public E peek() {
        if (empty()) {
            return null;
        }

        return top.getData();
    }

    /**
     * Removes the element at the top of the this stack and returns it. If the
     * stack is empty nothing changes and the function returns null.
     * @return the element at the top of this stack.
     */
    public E pop() {
        if (empty()) {
            return null;
        }

        E result = top.getData();
        top = top.getNeighbour();

        return result;
    }

    /**
     * Pushes an element onto the top of this stack.
     * @param newElement the element to be added onto the top of this stack.
     */
    public void push(final E newElement) {
        Node<E> newNode = new Node<>(newElement);

        if (empty()) {
            top = newNode;
        } else {
            newNode.setPrevious(top);
            top = newNode;
        }
    }
}
