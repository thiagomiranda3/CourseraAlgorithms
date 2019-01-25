package tests.sortings;

import br.com.tommiranda.algorithms.sortings.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;


public class SelectionSortTest extends BaseTest {

    private SelectionSort selection = new SelectionSort();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(selection.isSorted(ordenados), true);
        Assertions.assertEquals(selection.isSorted(iguais), true);
        Assertions.assertEquals(selection.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10, 0, 51)
                                             .boxed()
                                             .toArray(Integer[]::new);

        selection.print(numeros);

        selection.sort(numeros);
        Assertions.assertEquals(selection.isSorted(numeros), true);

        selection.print(numeros);
    }
}