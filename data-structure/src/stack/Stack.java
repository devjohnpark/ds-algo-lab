package stack;

import java.util.NoSuchElementException;

public class Stack {
    // We need thing can save data and link other thing.
    // It's node. so I'm going to be make node as inner class because it just used in Stack class
    private static class Node {
        private int data; // it's for saving data
        private Node next; // it's for pointing next node.

        // The node needs data initially when was created.
        private Node(int data) {
            this.data = data;
        }

        // Then next field for pointing previous node. so it is going to set when input the new node.
    }

    // The stack is First In Last Out data structure.
    // So, it needs to know where is top.
    // Then, we can add and remove from the top.
    private Node top; // remove node from the head

    // We need check that stack is empty, before remove the node.
    public boolean isEmpty() {
        return top == null; // The top is null means empty because don't have node at removing point.
    }

    // We need to get a data of the first node. so I'm gonna a make method return the data of the first node.
    public int peek() {
        if (top == null){ // it can't access data when head is null, so let's throw t he exception.
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    // Now, let's make method add a node to the last point.
    public void add(int data) {
        Node node = new Node(data); // we need to create new node.
        node.next = top; // this new node point to an old top. because this new node gonna a become the top.
        top = node; // and then the top point to new node.
    }

    // Also, let's make method remove the node. And it's going to return a data of first node.
    public int pop() {
        int data = peek(); // we can get the data of top node using peek method.
        top = top.next; // top need update to point down node. because top node is going to be removed.
        return data;
    }

    // Okay, so that's all add has to do.
}
