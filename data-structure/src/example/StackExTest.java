package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackExTest {
    StackEx stackEx;

    @BeforeEach
    void setUp() {
        stackEx = new StackEx();
    }

    @Test
    void push() {
        stackEx.push(10);
        assertEquals(10, stackEx.peek());
    }

    @Test
    void pop() {
        stackEx.push(10);
        assertEquals(10, stackEx.pop());
        stackEx.push(20);
        assertEquals(20, stackEx.pop());
    }

    @Test
    void pop_empty() {
        assertThrows(EmptyStackException.class,() -> stackEx.pop());
    }

    @Test
    void peek() {
        stackEx.push(10);
        assertEquals(10, stackEx.peek());
        stackEx.push(20);
        assertEquals(20, stackEx.peek());
        assertEquals(20, stackEx.peek());
    }

    @Test
    void peek_empty() {
        assertThrows(EmptyStackException.class,() -> stackEx.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(stackEx.isEmpty());
        stackEx.push(10);
        assertFalse(stackEx.isEmpty());
    }
}