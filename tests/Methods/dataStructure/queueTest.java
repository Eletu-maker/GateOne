package Methods.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class queueTest {

    @Test
    public void test_that_is_empty(){
        queue queue = new queue(5);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_that_add_work(){
        queue queue = new queue(5);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        assertEquals(3,queue.size());
    }

    @Test
    public void test_that_add_error_work(){
        queue queue = new queue(5);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            queue.add(6);
        });
        assertEquals("stack is full.", exception.getMessage());
    }

    @Test
    public void test_that_offer_work(){
        queue queue = new queue(5);

        assertTrue(queue.offer(1));
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(1));
        assertFalse(queue.offer(1));
    }

    @Test
    public void test_that_remove_work(){
        queue queue = new queue(5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            queue.remove();
        });
        assertEquals("NoSuchElementException.", exception.getMessage());

        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.remove();
        assertEquals(3,queue.size());
    }

    @Test
    public void test_that_poll_work(){
        queue queue = new queue(5);
        assertNull(queue.poll());
        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        assertEquals("[4, 4, 4]",queue.poll());
    }

    @Test
    public void tesr_that_element_work(){
        queue queue = new queue(5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            queue.element();
        });
        assertEquals("NoSuchElementException.", exception.getMessage());

        queue.add(41);
        queue.add(4);
        queue.add(4);
        queue.add(4);

        assertEquals(41,queue.element());
    }

    @Test
    public void test_that_peek_work(){
        queue queue = new queue(5);
        assertNull(queue.peek());
        queue.add(9);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        assertEquals("9",queue.peek());
    }

    @Test
    public void test_that_clear_work(){
        queue queue = new queue(5);
        queue.add(2);
        queue.add(1);
        queue.add(9);
        queue.remove();
        queue.add(3);
        queue.clear();
        assertTrue(queue.isEmpty());
    }
}