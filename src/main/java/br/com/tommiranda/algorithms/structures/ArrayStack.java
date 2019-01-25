package br.com.tommiranda.algorithms.structures;

public class ArrayStack<T> {

    private T[] s;
    private int N = 0;

    public ArrayStack() {
        s = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        if (N == s.length)
            resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < N; i++)
            copy[i] = s[i];

        s = copy;
    }

    public T pop() {
        T item = s[--N];
        s[N] = null;
        return item;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println("]");
    }
}
