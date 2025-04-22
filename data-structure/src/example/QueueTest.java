package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.concept.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(2);
        assertFalse(queue.isEmpty());
    }

    @Test
    void add() {
        queue.add(1);
        assertEquals(1, queue.remove());
        queue.add(2);
        assertEquals(2, queue.remove());
    }

    @Test
    void remove() {
        queue.add(1);
        assertEquals(1, queue.remove());
        assertThrows(RuntimeException.class, queue::remove);
    }

    @Test
    void peek() {
        assertThrows(RuntimeException.class, queue::remove);
        queue.add(1);
        assertEquals(1, queue.peek());
    }
}