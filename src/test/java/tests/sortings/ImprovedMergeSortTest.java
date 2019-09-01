package tests.sortings;

import br.com.tommiranda.algorithms.sortings.ImprovedMergeSort;
import br.com.tommiranda.algorithms.sortings.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.concurrent.ThreadLocalRandom;


public class ImprovedMergeSortTest extends BaseTest {

    private ImprovedMergeSort merge = new ImprovedMergeSort();

    @Test
    public void testaIsSorted() {
        Integer[] ordenados = {1, 2, 3, 4};
        Integer[] iguais = {5, 5, 5, 5};
        Integer[] desordenados = {4, 3, 1, 2};

        Assertions.assertEquals(merge.isSorted(ordenados), true);
        Assertions.assertEquals(merge.isSorted(iguais), true);
        Assertions.assertEquals(merge.isSorted(desordenados), false);
    }

    @Test
    public void testaOrdenacao() {
        Integer[] numeros = ThreadLocalRandom.current()
                                             .ints(10, 0, 51)
                                             .boxed()
                                             .toArray(Integer[]::new);

        merge.print(numeros);

        merge.sort(numeros);
        merge.print(numeros);

        Assertions.assertEquals(merge.isSorted(numeros), true);
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
        merge.sort(numeros);
        long nanoTime = (System.nanoTime() - startTime);

        printTempos(nanoTime);
    }
}