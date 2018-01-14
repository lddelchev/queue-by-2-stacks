package com.x8academy.queuetask.stack;

/**
 * A collection that offers LIFO operations on its elements.
 * @param <E> the type of the elements in the stack.
 */
public interface Stack<E> {
    /**
     * Checks if the stack is empty.
     * @return true if the stack has no elements and false if it contains
     * at least one element
     */
    boolean empty();

    /**
     * Returns the element at the top of this stack without removing it. If the
     * stack is empty the method returns null.
     * @return the element at the top of this stack.
     */
    E peek();

    /**
     * Returns the element at the top of the this stack and removes it. If the
     * stack is empty nothing changes and the method returns null.
     * @return the element at the top of this stack.
     */
    E pop();

    /**
     * Pushes an element onto the top of this stack.
     * @param newElement the element to be added onto the top of this stack.
     */
    void push(E newElement);
}
