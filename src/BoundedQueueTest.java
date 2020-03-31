import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BoundedQueueTest {
    @Test
    public void newQueueIsEmpty() {
        BoundedQueue<String> queue = new BoundedQueue<String>(/*capacity:*/ 3, /*dropOldest:*/ false);
        assertTrue(queue.empty(), "new BoundedQueue should be empty");
    }

    @Test
    public void queueWithItemIsNotEmpty() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("hello");
        assertTrue(!queue.empty(), "BoundedQueue should not be empty after an item is added");
    }

    @Test
    public void newQueueIsNoItems() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        assertEquals(queue.count(),0,"BoundedQueue's items should be 0");
    }

    @Test
    public void newQueueHasItems() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("Charlie");
        assertEquals(queue.count(),1,"BoundedQueue's items should not be 0 after an item is added");
    }

    @Test
    public void newQueueNotFull() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("Charlie");
        assertFalse(queue.full(),"BoundedQueue return should not be true because the queue has not reached its capacity");
    }

    @Test
    public void newQueueIsFull() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("Charlie");
        queue.put("Bob");
        queue.put("Alice");
        queue.put("Duke");
        assertTrue(queue.full(),"BoundedQueue return should be true because the queue has reached its capacity");
    }

    @Test
    public void newQueuePutOne() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("Charlie");
        assertEquals(queue.count(),1,"BoundedQueue items should 1 after 1 item is added");
    }

    @Test
    public void newQueuePutTwo() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("Charlie");
        queue.put("Charlie");
        assertEquals(queue.count(),2,"BoundedQueue items should 2 after 2 items are added");
    }

    @Test
    public void queueWithDropOldest(){
        BoundedQueue<String> queue = new BoundedQueue<String>(3,true);
        // Check the count
        assertEquals(queue.count(),0);
        // Add three items to the queue
        queue.put("item1");
        queue.put("item2");
        queue.put("item3");

        assertEquals(queue.get(),"item1");
        assertEquals(queue.count(),2);

        queue.put("item4");
        assertEquals(queue.get(),"item2");
        assertEquals(queue.count(),2, "BoundedQueue items should 2 after 1 item is dropped");
    }

    @Test
    public void queueWithDropOldestFalse(){
        BoundedQueue<String> queue = new BoundedQueue<String>(3,false);
        // Check the count
        assertEquals(queue.count(),0);
        // Add three items to the queue
        queue.put("item1");
        queue.put("item2");
        queue.put("item3");

        assertEquals(queue.get(),"item1");
        assertEquals(queue.count(),2, "BoundedQueue items should 2 after 1 item is dropped");

        queue.put("item4");
        assertEquals(queue.get(),"item2");
        assertEquals(queue.count(),2,"BoundedQueue items should 2 after 1 item is dropped");
    }


    @AfterEach
    public void reportStats() {
        BoundedQueue.reportStats();
    }
}
