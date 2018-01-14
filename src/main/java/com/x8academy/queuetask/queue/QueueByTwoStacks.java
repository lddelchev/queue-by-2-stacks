package com.x8academy.queuetask.queue;

import com.x8academy.queuetask.stack.LinkedStack;
import com.x8academy.queuetask.stack.Stack;

/**
 * Implementation of queue by two stacks.
 * @param <E> the type of the elements in the queue.
 */
public final class QueueByTwoStacks<E> implements Queue<E> {
    /**
     * Contains the elements that are pushed in the queue, but are still not in
     * the frontStack.
     */
    private final Stack<E> backStack = new LinkedStack<>();

    /**
     * Contains the elements that will be returned when pop() method called.
     * If this stack becomes empty, then if there are elements in the backStack
     * they are moved to this stack.
     */
    private final Stack<E> frontStack = new LinkedStack<>();

    /**
     * Checks if the queue is empty.
     * @return true if the queue has no elements and false if it contains
     * at least one element
     */
    public boolean empty() {
        return backStack.empty() && frontStack.empty();
    }

    /**
     * Returns the element at the top of this queue without removing it. If the
     * queue is empty the method returns null.
     * @return the element at the top of this queue.
     */
    public E peek() {
        if (shouldRestructureStacks()) {
            transferPushedElements();
        }

        return frontStack.peek();
    }

    /**
     * Removes the element at the front of this queue and returns it. If the
     * queue is empty nothing changes and the method returns null.
     * @return the element at the top of this queue.
     */
    public E pop() {
        if (shouldRestructureStacks()) {
            transferPushedElements();
        }

        return frontStack.pop();
    }

    /**
     * Pushes an element at the back of this queue.
     * @param newElement the element to be added to the back of this queue.
     */
    public void push(final E newElement) {
        backStack.push(newElement);
    }

    private boolean shouldRestructureStacks() {
        return frontStack.empty() && !backStack.empty();
    }

    private void transferPushedElements() {
        assert !backStack.empty()
                : "The stack for pushed elements shouldn't be empty.";
        assert frontStack.empty()
                : "The stack for front elements should be empty, otherwise"
                + "the fifo order won't be preserved";

        while (!backStack.empty()) {
            frontStack.push(backStack.pop());
        }
    }
}
