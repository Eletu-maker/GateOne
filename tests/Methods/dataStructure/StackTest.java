package Methods.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
 @Test
 public void test_that_push_work(){
     Stack stack = new Stack(5);
     stack.push(4);
     assertEquals(1,stack.size());
 }
 @Test
 public void test_that_stack_is_full(){
     Stack stack = new Stack(5);
     stack.push(4);
     stack.push(4);
     stack.push(4);
     stack.push(4);
     stack.push(4);


     Exception exception = assertThrows(IllegalArgumentException.class, () -> {
         stack.push(6);
     });
     assertEquals("stack is full.", exception.getMessage());
 }


 @Test
    public void test_that_is_empty(){
     Stack stack = new Stack(5);
     assertTrue(stack.isEmpty());
 }

    @Test
    public void test_that_is_not_empty(){
        Stack stack = new Stack(5);
        stack.push(4);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_that_pop_work(){
        Stack stack = new Stack(5);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.pop();
        assertEquals(2,stack.size());
    }



    @Test
    public void test_that_peek_work(){
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(4);
        stack.push(4);

        assertEquals(2,stack.peek());
    }

    @Test
    public void test_all_methods_together(){
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.pop();
        stack.push(3);
       assertEquals(1,stack.peek());
       assertEquals(3,stack.size());
    }

    @Test
    public void test_that_clear_work(){
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.pop();
        stack.push(3);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_the_error_messagw(){
        Stack stack = new Stack(5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stack.pop();
        });
        assertEquals("stack is empty.", exception.getMessage());
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            stack.peek();
        });
        assertEquals("stack is empty.", exception1.getMessage());


    }

}