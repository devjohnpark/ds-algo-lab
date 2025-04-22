package example;

import java.util.EmptyStackException;

public class StackEx {
    private static class Node {
        int data;
        Node next;

        // 생성자 활용을 빼먹음
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
    }

    public int pop() {
        int data = peek();
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
