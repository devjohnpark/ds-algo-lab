package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/* 5. Prove your data structure functions correctly.
Test scenario
1) stack instance initialization test. then check if the stack is empty.
2) get the data of top node when stack is empty. then check if it throws an exception.
3) input node then get the data of top node. then check if the input node's data matches the top node's data.
4) input node then remove the data of the top node. then check if the stack is empty.
5) input two nodes then get the data of the top node. then check if the top node was updated to the new node.
6) input two nodes then remove the data of the top node. then check if the top node was updated to old top node.
 */
class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    // Let's express the test case as given, when, then.

    /* 1)
    given: nothing
    when: create stack instance
    then: stack is empty
    */
    @Test
    void valid_stack_initialization() {
        assertTrue(stack.isEmpty());
    }

    /* 2)
    given: empty stack
    when: call peek method
    then: throw NoSuchElementException
    */
    @Test
    void get_data_from_empty_stack() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    /* 3)
    given: push node
    when: call peek method
    then: equal data of input node
     */
    @Test
    void get_data_after_push_node() {
        stack.push(10);
        assertEquals(10, stack.peek());
    }

    /* 4)
    given: push node
    when: pop node
    then: stack empty.
     */
    @Test
    void remove_data_after_push_node() {
        stack.push(10);
        assertEquals(10, stack.pop()); // also check if pop return data of top node.
        assertTrue(stack.isEmpty());
    }

    /* 5)
    given: nothing
    when: push two nodes
    then: top node data equal last node data
     */
    @Test
    void check_top_node_after_push_nodes() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    /* 6)
    given: nothing
    when: push two nodes then pop node
    then: top node data equal last node data
     */
    @Test
    void check_top_node_after_push_nodes_then_pop_node() {
        stack.push(10);
        stack.push(20);
        stack.pop();
        assertEquals(10, stack.peek());
    }
}