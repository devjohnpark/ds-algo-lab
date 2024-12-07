package queue;

import java.util.NoSuchElementException;

public class Queue {

    // We need thing can save data and link other thing.
    // It's node. so I'm going to be make node as inner class because it just used in Queue class
    private static class Node {
        private int data; // it's for saving data
        private Node next; // it's for pointing next node

        // The node needs data initially when was created.
        private Node(int data) {
            this.data = data;
        }

        // Then next field for pointing new node. so it is going to set when input the new node.
    }

    // The queue is First In First Out data structure.
    // So, it needs to know where is head and tail.
    // Then, we can remove from the head and add from the tail.
    private Node head; // remove node from the head
    private Node tail; // add node to tail

    // We need check that queue is empty, before remove the node.
    public boolean isEmpty() {
        return head == null; // The head is null means empty because don't have node at removing point.
    }

    // We need to get a data of the first node. so I'm gonna a make method return the data of the first node.
    public int peek() {
        if (head == null){ // it can't access data when head is null, so let's throw the exception.
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    // Now, let's make method add the node.
    public void add(int data) {
        Node node = new Node(data); // we need to create new node.
        if (tail != null) { // the tail isn't null when queue is not empty
            tail.next = node; // tail have to point new node.
        }
        tail = node; // update tail to new node. because now new node is last node.
        if (head == null) { // the head is null when queue is empty
            head = tail; // update head to new node. because now new node is first node.
        }
    }

    // Also, let's make method remove the node. And it's going to return a data of first node.
    public int remove() {
        int data = peek(); // we can get the data of head node using peek method.
        head = head.next; // update head to next node. because first node is going to be removed\.
        if (head == null) { // if the queue is empty due to node removal.
            tail = null;  // tail have to update to null.
        }
        return data;
    }

    // Okay, so that's all add has to do.
}
