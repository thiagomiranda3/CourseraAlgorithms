package br.com.tommiranda.algorithms.trees;

public final class Node<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> left;
    public Node<Key, Value> right;

    private Key key;
    private Value value;
    private int count = 1;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
