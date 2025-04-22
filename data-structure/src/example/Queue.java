package example;

public class Queue {
    private static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        // update head variable
        if (head == null) {
            head = tail;
        }
    }

    public int remove() {
        int data = peek();
        head = head.next;

        // update tail variable
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.data;
    }

}
