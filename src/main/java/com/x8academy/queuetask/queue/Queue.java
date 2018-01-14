package com.x8academy.queuetask.queue;

/**
 * A collection that offers FIFO operations on its elements.
 * @param <E> the type of the elements in the queue.
 */
public interface Queue<E> {
    /**
     * Checks if the queue is empty.
     * @return true if the queue has no elements and false if it contains
     * at least one element
     */
    boolean empty();

    /**
     * Returns the element at the top of this queue without removing it. If the
     * queue is empty the method returns null.
     * @return the element at the top of this queue.
     */
    E peek();

    /**
     * Removes the element at the front of this queue and returns it. If the
     * queue is empty nothing changes and the method returns null.
     * @return the element at the top of this queue.
     */
    E pop();

    /**
     * Pushes an element at the back of this queue.
     * @param newElement the element to be added to the back of this queue.
     */
    void push(E newElement);
}
