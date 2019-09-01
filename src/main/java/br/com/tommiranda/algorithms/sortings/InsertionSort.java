package br.com.tommiranda.algorithms.sortings;

// Coloca o próximo valor sempre na posição correta
public class InsertionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        // Um índice por vez
        for (int i = 0; i < a.length; i++) {
            // Encontra o menor valor do array
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j - 1]))
                // Troca o valor do índice atual pelo menor valor encontrado no array
                {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
        }
    }

    public void sortParcial(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--)
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
        }
    }
}
