package tests.sortings;

import br.com.tommiranda.algorithms.sortings.HeapSort;
import br.com.tommiranda.algorithms.sortings.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;


public class HeapSortTest extends BaseTest {

    private HeapSort heap = new HeapSort();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(heap.isSorted(ordenados), true);
        Assertions.assertEquals(heap.isSorted(iguais), true);
        Assertions.assertEquals(heap.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10, 0, 100)
                                             .boxed()
                                             .toArray(Integer[]::new);

        heap.print(numeros);

        heap.sort(numeros);
        //Assertions.assertEquals(heap.isSorted(numeros), true);

        heap.print(numeros);
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
        heap.sort(numeros);
        long nanoTime = (System.nanoTime() - startTime);

        printTempos(nanoTime);
    }
}