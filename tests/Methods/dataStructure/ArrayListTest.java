package Methods.dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {


    @Test
    public void test_that_arraylist_empty(){
        ArrayList   arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void test_that_arraylist_not_empty(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void test_that_getSize_work(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        assertEquals(3,arrayList.getSize());
    }

    @Test
    public void test_that_get_work(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        assertEquals("2",arrayList.get(1));
    }

    @Test
    public void test_get_arraylist(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        Object[] expected = new Object[] { "1", 2, true };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }

    @Test
    public void test_set_arraylist(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        //assertEquals(true,arrayList.get(2));
        arrayList.set(1,5);
        Object[] expected = new Object[] { "1", 5, true };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }

    @Test
    public void test_indexof(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        assertEquals(2,arrayList.indexof(true));
    }


    @Test
    public void test_pop(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.pop();
        assertEquals(3,arrayList.getSize());
        Object[] expected = new Object[] { "1", 2, true };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }

    @Test
    public void test_popfromfront(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.popFromfront();
        assertEquals(3,arrayList.getSize());
        Object[] expected = new Object[] { 2, true,false };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }


    @Test
    public void test_remove(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.add(19);
        arrayList.add("hello");
        arrayList.reomve(4);
        assertEquals(5,arrayList.getSize());
        Object[] expected = new Object[] {"1", 2, true,19,"hello" };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }


    @Test
    public void test_remove_by_element(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.add(19);
        arrayList.add("hello");
        arrayList.reomvebyElement(false);
        assertEquals(5,arrayList.getSize());
        Object[] expected = new Object[] {"1", 2, true,19,"hello" };
        assertArrayEquals(expected, (Object[]) arrayList.getData());

    }


    @Test
    public void test_clear(){
        ArrayList   arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(2);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.add(19);
        arrayList.add("hello");
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }
}