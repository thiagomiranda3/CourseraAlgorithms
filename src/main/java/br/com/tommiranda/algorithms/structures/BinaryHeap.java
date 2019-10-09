package br.com.tommiranda.algorithms.structures;

public class BinaryHeap {

    private int N = 0;
    private Comparable[] array;

    public BinaryHeap(int n) {
        N = n;
        this.array = new Comparable[N];
    }

    public void insert(Comparable a) {
        array[++N] = a;
        swim(N);
    }

    // Faz os nós trocarem com o pai, caso o filho seja maior
    public void swim(int k) {
        while (k > 0 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(j, j + 1)) {
                j++;
            }

            exch(k, j);
            k = j;
        }
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}
