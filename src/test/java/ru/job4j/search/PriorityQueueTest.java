package ru.job4j.search;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test

     void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 0));
        var result = queue.take();
        assertEquals(result.getDesc(), "middle");
    }

}