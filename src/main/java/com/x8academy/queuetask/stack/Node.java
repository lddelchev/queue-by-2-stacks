package com.x8academy.queuetask.stack;

/**
 * Represents a node in a linear data structure.
 * @param <E> the type of the data contained in the node.
 */
final class Node<E> {
    /**
     * The data stored in the node.
     */
    private final E data;

    /**
     * The neighbour neighbour node of this node.
     */
    private Node<E> neighbour;

    /**
     * Creates a new node by given data content.
     * @param data the content of the new node.
     */
    public Node(final E data) {
        this.data = data;
        this.neighbour = null;
    }

    /**
     *
     * @param data the content of this node.
     * @param neighbour the neighbour node of this node.
     */
    public Node(final E data, final Node<E> neighbour) {
        this.data = data;
        this.neighbour = neighbour;
    }

    /**
     *
     * @return the data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     *
     * @return the neighbour node, if available, otherwise null.
     */
    public Node<E> getNeighbour() {
        return neighbour;
    }

    /**
     *
     * @param newNeighbour the new value of neighbour.
     */
    public void setPrevious(final Node<E> newNeighbour) {
        this.neighbour = newNeighbour;
    }
}
