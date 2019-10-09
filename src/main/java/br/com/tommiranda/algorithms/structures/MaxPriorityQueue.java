package br.com.tommiranda.algorithms.structures;

public class MaxPriorityQueue {

    private Comparable[] pq;
    private int N = 0;

    public MaxPriorityQueue(int capacity) {
        this.pq = new Comparable[capacity + 1];
    }

    public void insert(Comparable x) {
        pq[++N] = x;
        swim(N);
    }

    // Faz os nós trocarem com o pai, caso o filho seja maior
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
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

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    public Comparable delMax() {
        Comparable max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;

        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 1; i <= N; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println("]");
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
