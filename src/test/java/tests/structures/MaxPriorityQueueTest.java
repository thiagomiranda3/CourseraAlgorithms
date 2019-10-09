package tests.structures;

import br.com.tommiranda.algorithms.structures.MaxPriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.ArrayList;

public class MaxPriorityQueueTest extends BaseTest {

    @Test
    public void testaFila() {
        var queue = new MaxPriorityQueue(10);

        queue.insert(2);
        queue.insert(5);
        queue.insert(3);
        queue.insert(1);
        queue.insert(4);

        queue.print();

        ArrayList<Comparable> numeros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numeros.add(queue.delMax());
        }

        System.out.println(numeros);
    }
}
