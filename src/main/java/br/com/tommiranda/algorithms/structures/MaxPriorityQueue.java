package br.com.tommiranda.algorithms.structures;

public class MaxPriorityQueue {

    private Comparable[] pq;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.pq = new Comparable[capacity];
    }

    public void insert(Comparable x) {
        pq[N++] = x;
    }

    public Comparable delMax() {
        int max = 0;

        for (int i = 1; i < N; i++) {
            if (less(pq[max], pq[i])) {
                max = i;
            }
        }

        exch(max, N - 1);

        return pq[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Comparable max() {
        return null;
    }

    public int size() {
        return N;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < N; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println("]");
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
