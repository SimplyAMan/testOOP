import com.study.datastructures.queue.LinkedQueue;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by dsk2 on 10/9/2018.
 */
public class LinkedQueueTest {
    @Test
    public void testEmpty(){
        LinkedQueue linkedQueue = new LinkedQueue();
        assertEquals(0,linkedQueue.size());
    }

    @Test
    public void testEnqueueOne() throws Exception {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        assertEquals(1,linkedQueue.size());
        assertEquals("A",linkedQueue.dequeue());
    }
    @Test
    public void testEnqueueTwo(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertEquals(2,linkedQueue.size());
        assertEquals("A",linkedQueue.dequeue());
        assertEquals(1,linkedQueue.size());
        assertEquals("B",linkedQueue.dequeue());
        assertEquals(0,linkedQueue.size());
    }
    @Test
    public void testEnqueueMany(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        linkedQueue.enqueue("E");

        assertEquals(5,linkedQueue.size());
        assertEquals("A",linkedQueue.dequeue());
        assertEquals(4,linkedQueue.size());
        assertEquals("B",linkedQueue.dequeue());
        assertEquals(3,linkedQueue.size());
        assertEquals("C",linkedQueue.dequeue());
        assertEquals(2,linkedQueue.size());
        assertEquals("D",linkedQueue.dequeue());
        assertEquals(1,linkedQueue.size());
        assertEquals("E",linkedQueue.dequeue());
        assertEquals(0,linkedQueue.size());
    }
    @Test
    public void testEnqueueWithNull(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue(null);
        linkedQueue.enqueue("B");

        assertEquals(3,linkedQueue.size());
        assertEquals("A",linkedQueue.dequeue());
        assertEquals(2,linkedQueue.size());
        assertEquals(null,linkedQueue.dequeue());
        assertEquals(1,linkedQueue.size());
        assertEquals("B",linkedQueue.dequeue());
        assertEquals(0,linkedQueue.size());
    }
    @Test
    public void testEnqueueQueueOnlyWithNull(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue(null);
        linkedQueue.enqueue(null);
        linkedQueue.enqueue(null);

        assertEquals(3,linkedQueue.size());
        assertEquals(null,linkedQueue.dequeue());
        assertEquals(2,linkedQueue.size());
        assertEquals(null,linkedQueue.dequeue());
        assertEquals(1,linkedQueue.size());
        assertEquals(null,linkedQueue.dequeue());
        assertEquals(0,linkedQueue.size());
    }

    @Test
    public void testPeek(){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue(null);
        linkedQueue.enqueue("B");

        assertEquals(3,linkedQueue.size());
        assertEquals("A",linkedQueue.peek());
        assertEquals(3,linkedQueue.size());
        assertEquals("A",linkedQueue.dequeue());
        assertEquals(2,linkedQueue.size());
        assertEquals(null,linkedQueue.peek());
        assertEquals(2,linkedQueue.size());
    }

    @Test
    public void testToString() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertEquals("[A,B]",linkedQueue.toString());
    }
    @Test
    public void testToStringWithNull() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue(null);
        linkedQueue.enqueue("B");

        assertEquals("[A,null,B]",linkedQueue.toString());
    }
}