package tests.structures;

import br.com.tommiranda.algorithms.structures.LinkedQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class LinkedQueueTest extends BaseTest {

    @Test
    public void testaFila() {
        var queue = new LinkedQueue();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        queue.print();

        Assertions.assertEquals(queue.dequeue(), "1");

        queue.enqueue("4");

        queue.print();

        Assertions.assertEquals(queue.dequeue(), "2");
        Assertions.assertEquals(queue.dequeue(), "3");
    }
}
