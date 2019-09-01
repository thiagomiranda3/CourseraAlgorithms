package tests.sortings;

import br.com.tommiranda.algorithms.sortings.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;


public class QuickSortTest extends BaseTest {

    private QuickSort quick = new QuickSort();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(quick.isSorted(ordenados), true);
        Assertions.assertEquals(quick.isSorted(iguais), true);
        Assertions.assertEquals(quick.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10, 0, 51)
                                             .boxed()
                                             .toArray(Integer[]::new);

        quick.print(numeros);

        quick.sort(numeros);
        Assertions.assertEquals(quick.isSorted(numeros), true);

        quick.print(numeros);
    }

    @Test
    public void verificaTempoOrdenacaoRandom() {
        System.out.println("==> GERANDO NÚMEROS");
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10000000)
                                             .boxed()
                                             .toArray(Integer[]::new);

        System.out.println("==> ORDENANDO VALORES");
        long startTime = System.nanoTime();
        quick.sort(numeros);
        long nanoTime = (System.nanoTime() - startTime);

        printTempos(nanoTime);
    }
}