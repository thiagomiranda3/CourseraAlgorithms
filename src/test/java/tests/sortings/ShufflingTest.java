package tests.sortings;

import br.com.tommiranda.algorithms.sortings.Shuffling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


public class ShufflingTest extends BaseTest {

    private Shuffling shuffling = new Shuffling();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(shuffling.isSorted(ordenados), true);
        Assertions.assertEquals(shuffling.isSorted(iguais), true);
        Assertions.assertEquals(shuffling.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = IntStream.range(0, 10)
                                      .boxed()
                                      .toArray(Integer[]::new);

        shuffling.print(numeros);
        Assertions.assertEquals(shuffling.isSorted(numeros), true);

        shuffling.sort(numeros);
        Assertions.assertEquals(shuffling.isSorted(numeros), false);

        shuffling.print(numeros);
    }
}