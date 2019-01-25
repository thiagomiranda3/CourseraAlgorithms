package br.com.tommiranda.algorithms.sortings;

public class SelectionSort extends BasicSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < a.length; i++) {
            int min = 0;

            for (int j = 0; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;

            exch(a, i, min);
        }
    }
}
