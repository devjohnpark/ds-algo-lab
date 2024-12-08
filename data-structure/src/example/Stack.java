package example;

/* 1. Explain a stack.
A stack data structure is much like an actual stack of plates.
The last plate you put on top of plates. That's going to be the first one you removed.
So the stack called Last In First Out data structure, and the stack has a flexible size. it doesn't need to allocate fix 50 initially.
 */

/* 2. What situations is it best or worst to use this data structure?
This is the best situation where you need to retrieve the last input data.
On the other hand, the worst situation where you need to retrieve the first input data.
 */

import java.util.NoSuchElementException;

/*
3. Design the data structure.
4. Explain while Implementing the data structure.
 */
public class Stack {
    // The stack has a lot of elements sequentially, and the element needs to link to the next element.
    // Then need an object which has data and points to itself, so I'm gonna to make the node object.
    private static class Node {
        int data;
        Node next;

        // The node instance needs the data when it was created.,
        private Node(int data) {
            this.data = data;
        }

        // On the other hand, the next field is going to update to the node top of stack.
    }

    // we need to track the node at top of stack.
    private Node top = null;

    // we need functions.
    // 1). to check before the node is going to be removed.
    // 2). to get the data top of the stack.
    // 3). add node to the top of stack.
    // 4). remove node to the top of stack.

    // 1)
    public boolean isEmpty() {
        return top == null;
    }

    // 2)
    public int peek() {
        // if the stack was empty, need exception that hasn't any element.
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    // 3)
    public void push(int data) {
        Node node = new Node(data); // create a new node to input.
        node.next = top; // link to the current top node. because it's going to be old top node.
        top = node; // then update to new node to top node.
    }
    // Okay, so that's all push has to do.

    // 4)
    public int pop() {
        int data = peek(); // get a dat of top node.
        top = top.next; // now the top node needs to update to below the top node. because the current top node is going to be removed.
        return data;
    }
    // Okay, so that's all pop has to do.
}
