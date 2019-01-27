package br.com.tommiranda.algorithms.sortings;

import java.util.concurrent.ThreadLocalRandom;

public class Shuffling extends BaseSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, i + 1);
            exch(a, i, r);
        }
    }
}
