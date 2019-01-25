package br.com.tommiranda.algorithms.sortings;

// Troca o índice atual pelo menor valor no array
public class SelectionSort extends BasicSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        // Um índice por vez
        for (int i = 0; i < a.length; i++) {
            int min = i;

            // Encontra o menor valor do array
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;

            // Troca o valor do índice atual pelo menor valor encontrado no array
            exch(a, i, min);
        }
    }
}
