package tests.sortings;

import br.com.tommiranda.algorithms.sortings.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;


public class InsertionSortTest extends BaseTest {

    private InsertionSort insertion = new InsertionSort();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(insertion.isSorted(ordenados), true);
        Assertions.assertEquals(insertion.isSorted(iguais), true);
        Assertions.assertEquals(insertion.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10, 0, 51)
                                             .boxed()
                                             .toArray(Integer[]::new);

        insertion.print(numeros);

        insertion.sort(numeros);
        Assertions.assertEquals(insertion.isSorted(numeros), true);

        insertion.print(numeros);
    }
}