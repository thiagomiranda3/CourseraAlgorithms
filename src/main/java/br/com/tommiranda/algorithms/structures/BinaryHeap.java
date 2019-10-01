package br.com.tommiranda.algorithms.structures;

public class BinaryHeap {

    private Comparable[] array;

    public void swim(int k) {
        while (k > 0 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
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
