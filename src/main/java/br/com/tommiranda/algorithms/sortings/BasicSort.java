package br.com.tommiranda.algorithms.sortings;

public abstract class BasicSort {

    // Verifica se o primeiro é menor que o segundo
    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // Troca as posições dos índices i e j
    protected void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }

    public void print(Comparable[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public abstract void sort(Comparable[] a);
}
