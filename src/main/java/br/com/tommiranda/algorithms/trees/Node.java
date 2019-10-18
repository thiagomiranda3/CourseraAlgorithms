package br.com.tommiranda.algorithms.trees;

public final class Node<Key extends Comparable<Key>, Value> {

    private final Key key;
    private Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }
}
