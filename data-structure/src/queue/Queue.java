package queue;

public class Queue {

    // Node is element of data structure.
    // I'm going to make it as inner class because it just used in Queue class
    private static class Node {
        private int data; // it needs to save data
        private Node next; // it needs to point next node

        // Node needs data initially
        // next field for pointing new node.so it is going to set when input the next node.
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; // remove node from the head
    private Node tail; // add node to tail

    // head null is empty because don't have any nodes at removing point
    public boolean isEmpty() {
        return head == null;
    }

    // it returns the data of the first node to be removed.
    public int peek() {
        return head.data;
    }

    // Okay, so that's all add has to do.
    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node; // tail have to point next node.
        }
        tail = node; // update tail to new node.
        if (head == null) {
            head = tail; // update head to first node.
        }
    }

    public int remove() {
        int data = head.data; // get data
        head = head.next; // update head to next node
        if (head == null) {
            tail = null;  // also tail update to head
        }
        return data;
    }

}
