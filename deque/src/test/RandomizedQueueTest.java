import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RandomizedQueueTest extends TestCase {

    @Test(expected = NullPointerException.class)
    public void test_enqueue_null_String() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue(null);
    }

    @Test
    public void test_enqueue_one_String() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("Foo");
        assertTrue(queue.size() == 1);
        assertTrue(queue.sample().equals("Foo"));
    }

    @Test
    public void test_enqueue_and_dequeue_one_String() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("Foo");
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_enqueue_multiple_Strings() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("Foo");
        queue.enqueue("Bar");
        queue.enqueue("Qix");
        assertTrue(queue.size() == 3);
        String sample = queue.sample();
        assertTrue(sample.equals("Foo")
                || sample.equals("Bar")
                || sample.equals("Qix"));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_dequeue_empty_queue() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.dequeue();
    }

    @Test
    public void test_dequeue() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("Foo");
        queue.enqueue("Bar");
        queue.enqueue("Qix");

        assertTrue(queue.size() == 3);

        String dequeued = queue.dequeue();

        assertTrue(queue.size() == 2);
        assertTrue(dequeued.equals("Foo")
                || dequeued.equals("Bar")
                || dequeued.equals("Qix"));
    }

    @Test
    public void test_iterator_on_empty_queue() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        Iterator<String> iterator = queue.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void test_iterator() {

        List<String> Strings = Arrays.asList("Foo", "Bar", "Qix");
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        List<String> filtered = null;

        queue.enqueue(Strings.get(0));
        queue.enqueue(Strings.get(1));
        queue.enqueue(Strings.get(2));
        assertTrue(queue.size() == 3);
        Iterator<String> iterator = queue.iterator();

        final String firstString = iterator.next();
        assertTrue(Strings.contains(firstString));

        filtered = filter(Strings, new Predicate<String>() {
            @Override
            public boolean verify(String element) {
                return !element.equals(firstString);
            }
        });

        final String secondString = iterator.next();
        assertTrue(filtered.contains(secondString));

        filtered = filter(Strings, new Predicate<String>() {
            @Override
            public boolean verify(String element) {
                return !element.equals(firstString);
            }
        });

        final String thirdString = iterator.next();
        assertTrue(filtered.contains(thirdString));

        System.out
                .println(firstString + " " + secondString + " " + thirdString);
    }

    private <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filtered = new ArrayList<T>();
        for (T element : list) {
            if (predicate.verify(element)) {
                filtered.add(element);
            }
        }
        return filtered;
    }

    private static interface Predicate<T> {
        boolean verify(T element);
    }
}
