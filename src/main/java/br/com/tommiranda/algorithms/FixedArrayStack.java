package br.com.tommiranda.algorithms;

public class FixedArrayStack {

    private String[] s;
    private int N = 0;

    public FixedArrayStack(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }
}