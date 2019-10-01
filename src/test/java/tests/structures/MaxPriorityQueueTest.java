package tests.structures;

import br.com.tommiranda.algorithms.structures.MaxPriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class MaxPriorityQueueTest extends BaseTest {

    @Test
    public void testaFila() {
        var queue = new MaxPriorityQueue(10);

        queue.insert(2);
        queue.insert(3);
        queue.insert(1);

        queue.print();

        Assertions.assertEquals(queue.delMax(), 3);

        queue.insert(4);

        queue.print();

        Assertions.assertEquals(queue.delMax(), 4);
        Assertions.assertEquals(queue.delMax(), 2);
    }
}
