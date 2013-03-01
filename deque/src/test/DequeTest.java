import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class DequeTest extends TestCase {

    @Test(expected = NullPointerException.class)
    public void test_add_first_null_String() {
        Deque<String> deque = new Deque<String>();
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_add_last_null_String() {
        Deque<String> deque = new Deque<String>();
        deque.addLast(null);
    }

    @Test
    public void test_add_first() {
        Deque<String> deque = new Deque<String>();
        String String = "Foo";
        deque.addFirst(String);
        assertTrue(deque.size() == 1);
        String first = deque.removeFirst();
        assertTrue(first.equals(String));
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_add_last() {
        Deque<String> deque = new Deque<String>();
        String String = "Foo";
        deque.addLast(String);
        assertTrue(deque.size() == 1);
        String last = deque.removeLast();
        assertTrue(last.equals(String));
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_add_first_and_last() {
        Deque<String> deque = new Deque<String>();
        deque.addLast("Foo");
        deque.addFirst("Bar");
        deque.addFirst("Foo");
        deque.addLast("Qix");
        Iterator<String> iterator = deque.iterator();
        assertTrue(iterator.next().equals("Foo"));
        assertTrue(iterator.next().equals("Bar"));
        assertTrue(iterator.next().equals("Foo"));
        assertTrue(iterator.next().equals("Qix"));
    }

    @Test
    public void test_remove_first_equals_remove_last_on_one_element_deque() {
        Deque<String> deque = new Deque<String>();
        String String = "Foo";
        deque.addFirst(String);
        String last = deque.removeLast();
        assertTrue(last.equals(String));
        assertTrue(deque.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_remove_first_from_empty_deque() {
        Deque<String> deque = new Deque<String>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_remove_last_from_empty_deque() {
        Deque<String> deque = new Deque<String>();
        deque.removeLast();
    }

    @Test
    public void test_iterator_on_empty_deque() {
        Deque<String> deque = new Deque<String>();
        Iterator<String> iterator = deque.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_iterator() {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("Foo");
        deque.addFirst("Bar");
        deque.addFirst("Qix");
        Iterator<String> iterator = deque.iterator();
        assertTrue(iterator.next().equals("Qix"));
        assertTrue(iterator.next().equals("Bar"));
        assertTrue(iterator.next().equals("Foo"));
        iterator.next();
    }

}
