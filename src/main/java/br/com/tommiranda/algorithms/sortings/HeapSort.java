package br.com.tommiranda.algorithms.sortings;

public class HeapSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        buildHeap(a, N);

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public void buildHeap(Comparable[] a, int N) {
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(a, j, j + 1)) {
                j++;
            }

            if (!less(a, k, j)) {
                break;
            }

            exch(a, k, j);
            k = j;
        }
    }

    // Verifica se o primeiro é menor que o segundo
    @Override
    protected boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    // Troca as posições dos índices i e j
    @Override
    protected void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }
}
