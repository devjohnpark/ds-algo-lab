package collections;

import java.util.NoSuchElementException;


public class Stack<E> {
    // We need thing can save data and link another thing.
    // It's a node. So I'm going to be make node as inner class because it just used in Stack class
    // We need thing can save data and link another thing. so I'm going to be make node\
    private static class Node<E> {
        private final E element; // it's for saving data
        private Node<E> next; // it's for pointing next node.

        public Node(E element) {
            this.element = element; // The node needs data initially when was created.
            this.next = null; // Then next field for pointing previous node. so it is going to set when input the new node.
        }
    }

    // 1) to check before the node is going to be removed.
    // 2) to get the data top of the stack.
    // 3) add node to the top of stack.
    // 4) remove node to the top of stack.

    // The stack is First In Last Out data structure.
    // So, it needs to know where is top.
    // Then, we can add and remove from the top.
    private Node<E> top = null; // remove node from the head

    // 1) We need check that stack is empty, before remove the node.
    public synchronized boolean isEmpty() {
        return top == null; // The top is null means empty because don't have node at removing point.
    }

    // 2) We need to get data of the first node. so I'm going to make method return the data of the first node.
    public synchronized E peek() {
        if (top == null){ // it can't access data when head is null, so let's throw the exception.
            throw new NoSuchElementException("Stack is empty");
        }
        return top.element;
    }

    // 3) Now, let's make method push a node to the last point.
    public synchronized void push(E element) {
        Node<E> node = new Node<>(element); // we need to create new node.
        node.next = top; // this new node point to an old top. because this new node gonna a become the top.
        top = node; // and then the top point to new node.
    }

    // 4) Also, let's make method remove the node. And it's going to return a data of top node.
    public synchronized E pop() {
        E data = peek(); // we can get the data of top node using peek method.
        top = top.next; // top need update to point down node. because top node is going to be removed.
        return data;
    }
}
