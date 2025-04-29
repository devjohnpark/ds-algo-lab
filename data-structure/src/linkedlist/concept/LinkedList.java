package linkedlist.concept;

public class LinkedList {
    // Node
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head
    private Node head = null;

    // void append(int data): add last node
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // void prepend(int data): add front of node
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // int delete(int data): remove node if equal data
    public void delete(int data) {
        // 노드 없을때
        if (head == null) {
            return;
        }
        // 노드 1개 일때 (head 만 있을때)
        if (head.data == data) {
            head = head.next;
            return;
        }
        // 최소 노드 두개 이상 일때 (next.next 접근)
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
